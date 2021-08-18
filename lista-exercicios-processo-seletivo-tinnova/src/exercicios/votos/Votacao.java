package exercicios.votos;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Votacao {
    private BigDecimal totalEleitores;
    private BigDecimal totalVotosValidos;
    private BigDecimal totalVotosBrancos;
    private BigDecimal totalVotosNulos;

    public void setTotalEleitores(BigDecimal totalEleitores) {
        this.totalEleitores = totalEleitores;
    }

    public void setTotalVotosValidos(BigDecimal totalVotosValidos) {
        this.totalVotosValidos = totalVotosValidos;
    }

    public void setTotalVotosBrancos(BigDecimal totalVotosBrancos) {
        this.totalVotosBrancos = totalVotosBrancos;
    }

    public void setTotalVotosNulos(BigDecimal totalVotosNulos) {
        this.totalVotosNulos = totalVotosNulos;
    }

    public BigDecimal percentualVotosValidos() {
        return totalVotosValidos.divide(totalEleitores);
    }

    public BigDecimal percentualVotosBrancos() {
        return totalVotosBrancos.divide(totalEleitores);
    }

    public BigDecimal percentualVotosNulos() {
        return totalVotosNulos.divide(totalEleitores);
    }

    public void mostrarResultadoVotacao() {
        NumberFormat formatPorcentagem = NumberFormat.getPercentInstance();
        System.out.println("Resultado da votação:");
        System.out.printf("Percentual de votos válidos: %s\n", formatPorcentagem.format(percentualVotosValidos()));
        System.out.printf("Percentual de votos em branco: %s\n", formatPorcentagem.format(percentualVotosBrancos()));
        System.out.printf("Percentual de votos nulos: %s\n", formatPorcentagem.format(percentualVotosNulos()));
    }
}
