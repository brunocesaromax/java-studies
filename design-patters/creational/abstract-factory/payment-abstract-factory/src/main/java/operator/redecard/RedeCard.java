package operator.redecard;

import operator.NotAuthorizedCaptureException;
import operator.Operator;

import java.math.BigDecimal;

public class RedeCard implements Operator {

    private Long confirmCode = -1L;

    @Override
    public void capture(String card, BigDecimal value) throws NotAuthorizedCaptureException {
        if (card.startsWith("2222") && biggerThenLimit(value)) {
            throw new NotAuthorizedCaptureException("Valor maior que limite para cartão informado.");
        }

        this.confirmCode = (long) Math.random() * 300;
    }

    private boolean biggerThenLimit(BigDecimal value) {
        var limit = new BigDecimal("1000");
        return value.compareTo(limit) > 0;
    }

    @Override
    public Long confirm() {
        System.out.println("Fazendo o débito na conta do cliente via Redecard");
        return this.confirmCode;
    }
}
