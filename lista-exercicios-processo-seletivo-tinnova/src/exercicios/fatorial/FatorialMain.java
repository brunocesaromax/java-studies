package exercicios.fatorial;

import java.math.BigInteger;
import java.util.Scanner;

public class FatorialMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número para calcular o fatorial:");

        BigInteger numero = null;
        do {
            if (numero != null) {
                System.out.println("Número inválido, digite um número maior ou igual a 0:");
            }
            numero = sc.nextBigInteger();
        } while (numero.compareTo(BigInteger.ZERO) < 0); //numero < 0

        System.out.printf("Fatorial de %d: %d", numero, calcularFatorial(numero));
    }

    public static BigInteger calcularFatorial(BigInteger numero) {
        if (numero.compareTo(BigInteger.ZERO) == 0) { // 0 == 0
            return BigInteger.ONE;
        } else {
            return numero.multiply(calcularFatorial(numero.subtract(BigInteger.ONE)));
        }
    }
}
