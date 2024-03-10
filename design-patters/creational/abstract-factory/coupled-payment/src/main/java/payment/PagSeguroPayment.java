package payment;

import operator.Cielo;
import operator.NotAuthorizedCaptureException;
import riskmanager.AlertRiskException;
import riskmanager.FControl;

import java.math.BigDecimal;

public class PagSeguroPayment {

    private Cielo operator;
    private FControl riskManager;

    public PagSeguroPayment(Cielo operator, FControl riskManager) {
        this.operator = operator;
        this.riskManager = riskManager;
    }

    public Long authorize(String card, BigDecimal value) throws NotAuthorizedCaptureException, AlertRiskException {
        this.operator.capture(card, value);
        this.riskManager.assessRisk(card, value);
        return this.operator.confirm();
    }
}
