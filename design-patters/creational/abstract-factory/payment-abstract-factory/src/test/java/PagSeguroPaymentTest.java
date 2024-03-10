import operator.NotAuthorizedCaptureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.Payment;
import payment.PaymentModuleFactory;
import payment.pagseguro.PagSeguroPaymentModuleFactory;
import riskmanager.AlertRiskException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PagSeguroPaymentTest {

    private Payment payment;

    @BeforeEach
    public void init() {
        PaymentModuleFactory paymentModuleFactory = new PagSeguroPaymentModuleFactory();
        payment = new Payment(paymentModuleFactory);
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
