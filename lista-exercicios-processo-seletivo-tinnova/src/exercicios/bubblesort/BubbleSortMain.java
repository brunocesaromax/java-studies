package exercicios.bubblesort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSortMain {

    public static void main(String[] args) {
        Integer[] vetor = new Integer[]{5, 3, 2, 4, 7, 1, 0, 6};
        System.out.println("Vetor inicial:");
        mostrarVetor(vetor);

        SimuladorBubbleSort simuladorBubbleSort = new SimuladorBubbleSort(vetor);
        simuladorBubbleSort.ordenar();

        System.out.println("Vetor Final:");
        mostrarVetor(vetor);
    }

    private static void mostrarVetor(Integer[] vetor) {
        System.out.println(Arrays.stream(vetor).map(Object::toString).collect(Collectors.joining(",")));
    }
}
