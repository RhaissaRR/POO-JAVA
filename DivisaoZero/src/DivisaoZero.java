import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisaoZero {

    public static int divide(int numerador, int denominador) {
        if (denominador == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }

        return numerador / denominador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor informe o inteiro numerador: ");
        while (true) {
            try {
                int numerador = scanner.nextInt();
                System.out.print("Por favor informe o inteiro denominador: ");
                int denominador = scanner.nextInt();

                try {
                    int resultado = divide(numerador, denominador);
                    System.out.printf("\nResultado: %d / %d = %d\n", numerador, denominador, resultado);
                    break; // Sai do loop while após a divisão bem-sucedida
                } catch (ArithmeticException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Digite apenas números inteiros.");
                scanner.next(); // Consumir a entrada inválida para evitar loop infinito
            }
        }

        scanner.close();
    }
}
