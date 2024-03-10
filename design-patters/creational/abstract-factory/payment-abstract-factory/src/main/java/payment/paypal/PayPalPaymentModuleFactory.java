package payment.paypal;

import operator.Operator;
import operator.redecard.RedeCard;
import payment.PaymentModuleFactory;
import riskmanager.RiskManager;
import riskmanager.clearsale.ClearSale;

public class PayPalPaymentModuleFactory implements PaymentModuleFactory {

    @Override
    public Operator createOperator() {
        return new RedeCard();
    }

    @Override
    public RiskManager createRiskManager() {
        return new ClearSale();
    }
}
