package riskmanager.clearsale;

import riskmanager.AlertRiskException;
import riskmanager.RiskManager;

import java.math.BigDecimal;

public class ClearSale implements RiskManager {

    @Override
    public void assessRisk(String card, BigDecimal value) throws AlertRiskException {
        if (card.startsWith("1111") && veryHighValue(value)) {
            throw new AlertRiskException("Valor muito alto para esse cartão");
        }
    }

    private boolean veryHighValue(BigDecimal value) {
        var limit = new BigDecimal("5000");
        return limit.compareTo(value) < 0;
    }
}
