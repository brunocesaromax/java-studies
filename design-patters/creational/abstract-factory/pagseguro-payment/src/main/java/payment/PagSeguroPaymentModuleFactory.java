package payment;

import operator.Cielo;
import operator.Operator;
import riskmanager.FControl;
import riskmanager.RiskManager;

public class PagSeguroPaymentModuleFactory implements PaymentModuleFactory {

    @Override
    public Operator createOperator() {
        return new Cielo();
    }

    @Override
    public RiskManager createRiskManager() {
        return new FControl();
    }
}
