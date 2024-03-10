import operator.NotAuthorizedCaptureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.Payment;
import payment.PaymentModuleFactory;
import payment.paypal.PayPalPaymentModuleFactory;
import riskmanager.AlertRiskException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PayPalPaymentTest {

    private Payment payment;

    @BeforeEach
    public void init() {
        PaymentModuleFactory paymentModuleFactory = new PayPalPaymentModuleFactory();
        payment = new Payment(paymentModuleFactory);
    }

    @Test
    void shouldAuthorizeSale() throws NotAuthorizedCaptureException, AlertRiskException {
        Long authorizationCode = payment.authorize("2222.2222", new BigDecimal("200"));
        assertNotNull(authorizationCode);
    }

    @Test
    void shouldDenyCapture_valueAboveCardLimit() throws NotAuthorizedCaptureException, AlertRiskException {
        assertThrows(NotAuthorizedCaptureException.class, () -> payment.authorize("2222.2222", new BigDecimal("2000")));
    }

    @Test
    void shouldAuthorizeSale_highValueWithValidCard() throws NotAuthorizedCaptureException, AlertRiskException {
        Long authorizeCode = payment.authorize("3333.2222", new BigDecimal("2000"));
        assertNotNull(authorizeCode);
    }

    @Test
    void shouldGenerateAlertRisk() throws NotAuthorizedCaptureException, AlertRiskException {
        assertThrows(AlertRiskException.class, () -> payment.authorize("1111.2222", new BigDecimal("5500")));
    }
}
