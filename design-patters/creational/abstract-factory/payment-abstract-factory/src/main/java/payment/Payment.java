package payment;

import operator.NotAuthorizedCaptureException;
import operator.Operator;
import riskmanager.AlertRiskException;
import riskmanager.RiskManager;

import java.math.BigDecimal;

public class Payment {

    private final Operator operator;
    private final RiskManager riskManager;

    public Payment(PaymentModuleFactory paymentModuleFactory) {
        this.operator = paymentModuleFactory.createOperator();
        this.riskManager = paymentModuleFactory.createRiskManager();
    }

    public Long authorize(String card, BigDecimal value) throws NotAuthorizedCaptureException, AlertRiskException {
        this.operator.capture(card, value);
        this.riskManager.assessRisk(card, value);
        return this.operator.confirm();
    }
}
