package riskmanager;

import java.math.BigDecimal;

public class FControl implements RiskManager {

    @Override
    public void assessRisk(String card, BigDecimal value) throws AlertRiskException {
        if (card.startsWith("7777")) {
            throw new AlertRiskException("Cartão suspeito.");
        }
    }
}
