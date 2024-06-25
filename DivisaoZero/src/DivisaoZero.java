import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisaoZero {

    public static int divide(int numerador, int denominador) {
        if (denominador == 0) {
            throw new ArithmeticException("N�o � poss�vel dividir por zero!");
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
                    break; // Sai do loop while ap�s a divis�o bem-sucedida
                } catch (ArithmeticException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inv�lida. Digite apenas n�meros inteiros.");
                scanner.next(); // Consumir a entrada inv�lida para evitar loop infinito
            }
        }

        scanner.close();
    }
}
