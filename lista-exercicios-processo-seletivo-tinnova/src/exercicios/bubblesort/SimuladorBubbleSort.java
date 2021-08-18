package exercicios.bubblesort;

public class SimuladorBubbleSort {
    private Integer[] vetor;

    public SimuladorBubbleSort(Integer[] vetor) {
        this.vetor = vetor;
    }

    public void ordenar() {
        int posicaoLimite = vetor.length - 1;

        for (int i = 0; i < posicaoLimite; posicaoLimite--) {
            for (int posicaoAtual = 0, posicaoPosterior = posicaoAtual + 1; posicaoAtual < posicaoLimite; posicaoAtual++, posicaoPosterior++) {
                if (vetor[posicaoAtual] > vetor[posicaoPosterior]) {
                    troca(posicaoAtual, posicaoPosterior);
                }
            }
        }
    }

    private void troca(int posicaoAtual, int posicaoPosterior) {
        int valorPosicaoAtual = vetor[posicaoAtual];
        vetor[posicaoAtual] = vetor[posicaoPosterior];
        vetor[posicaoPosterior] = valorPosicaoAtual;
    }
}
