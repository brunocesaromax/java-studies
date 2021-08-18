package exercicios.multiplos;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplosMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número para se obter a soma de todos os numeros multiplos de 3 ou 5 abaixo desse numero:");

        BigInteger numero = null;
        do {
            if (numero != null) {
                System.out.println("Número inválido, digite um número maior ou igual a 0:");
            }
            numero = sc.nextBigInteger();
        } while (numero.compareTo(BigInteger.ZERO) < 0); //numero < 0

        System.out.printf("Soma = %d", calcularSoma(numero));
    }

    private static BigInteger calcularSoma(BigInteger numero) {
        BigInteger soma = BigInteger.ZERO;

        for (int i = 1; i < numero.intValue(); i++){
            if (i % 3 == 0 || i % 5 == 0){
                soma = soma.add(BigInteger.valueOf(i));
            }
        }

        return soma;
    }
}
