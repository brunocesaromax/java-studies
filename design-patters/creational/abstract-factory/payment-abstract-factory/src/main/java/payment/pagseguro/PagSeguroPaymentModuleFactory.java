package payment.pagseguro;

import operator.Operator;
import operator.cielo.Cielo;
import payment.PaymentModuleFactory;
import riskmanager.RiskManager;
import riskmanager.fcontrol.FControl;

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
