package exercicios.votos;

import java.math.BigDecimal;

public class VotacaoMain {

    public static void main(String[] args) {
        Votacao votacao = new Votacao();
        votacao.setTotalEleitores(BigDecimal.valueOf(1000));
        votacao.setTotalVotosValidos(BigDecimal.valueOf(800));
        votacao.setTotalVotosBrancos(BigDecimal.valueOf(150));
        votacao.setTotalVotosNulos(BigDecimal.valueOf(50));
        votacao.mostrarResultadoVotacao();
    }
}
