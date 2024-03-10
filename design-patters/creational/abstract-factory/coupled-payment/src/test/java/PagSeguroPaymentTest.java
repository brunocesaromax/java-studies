import operator.Cielo;
import operator.NotAuthorizedCaptureException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.PagSeguroPayment;
import riskmanager.AlertRiskException;
import riskmanager.FControl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PagSeguroPaymentTest {

    private PagSeguroPayment payment;

    @BeforeEach
    public void init() {
        Cielo cielo = new Cielo();
        FControl fControl = new FControl();
        payment = new PagSeguroPayment(cielo, fControl);
    }

    @Test
    void shouldAuthorizeSale() throws NotAuthorizedCaptureException, AlertRiskException {
        Long authorizationCode = payment.authorize("2222.2222", new BigDecimal("200"));
        assertNotNull(authorizationCode);
    }

    @Test
    void shouldDenyCapture_invalidCard() throws NotAuthorizedCaptureException, AlertRiskException {
        assertThrows(NotAuthorizedCaptureException.class, () -> payment.authorize("5555.2222", new BigDecimal("2000")));
    }

    @Test
    void shouldGenerateAlertRisk() throws NotAuthorizedCaptureException, AlertRiskException {
        assertThrows(AlertRiskException.class, () -> payment.authorize("7777.2222", new BigDecimal("5500")));
    }
}
