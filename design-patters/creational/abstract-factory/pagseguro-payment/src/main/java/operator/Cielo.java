package operator;

import java.math.BigDecimal;

import static java.lang.Math.random;

public class Cielo implements Operator {

    private Long confirmCode = -1L;

    @Override
    public void capture(String card, BigDecimal value) throws NotAuthorizedCaptureException {
        if (card.startsWith("5555")) {
            throw new NotAuthorizedCaptureException("Número de cartão inválido!");
        }

        this.confirmCode = (long) (random() * 1000);
    }

    @Override
    public Long confirm() {
        System.out.println("Fazendo débito na conta do cliente via Cielo");
        return this.confirmCode;
    }
}
