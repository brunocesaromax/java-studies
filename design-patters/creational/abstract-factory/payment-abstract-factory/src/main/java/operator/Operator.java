package operator;

import java.math.BigDecimal;

public interface Operator {

    void capture(String card, BigDecimal value) throws NotAuthorizedCaptureException;

    Long confirm();
}
