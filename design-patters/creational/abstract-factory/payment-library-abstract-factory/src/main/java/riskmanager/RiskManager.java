package riskmanager;

import java.math.BigDecimal;

public interface RiskManager {

    void assessRisk(String card, BigDecimal value) throws AlertRiskException;
}
