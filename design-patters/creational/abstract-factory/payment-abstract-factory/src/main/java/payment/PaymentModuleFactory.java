package payment;

import operator.Operator;
import riskmanager.RiskManager;

public interface PaymentModuleFactory {

    Operator createOperator();

    RiskManager createRiskManager();

}
