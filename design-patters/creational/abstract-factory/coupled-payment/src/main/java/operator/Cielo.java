package operator;

import java.math.BigDecimal;

import static java.lang.Math.random;

public class Cielo {

    private Long confirmCode = -1L;

    public void capture(String card, BigDecimal value) throws NotAuthorizedCaptureException {
        if (card.startsWith("5555")) {
            throw new NotAuthorizedCaptureException("Número de cartão inválido!");
        }

        this.confirmCode = (long) (random() * 1000);
    }

    public Long confirm() {
        System.out.println("Fazendo débito na conta do cliente via Cielo");
        return this.confirmCode;
    }
}
