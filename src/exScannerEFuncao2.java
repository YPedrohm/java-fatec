import java.util.Scanner;

public class exScannerEFuncao2 {
    public static int soma(int a, int b) {
        int soma = a + b;
        return soma;
    }
    public static void main (String[] args) {
        Scanner teclado =  new Scanner(System.in);
        System.out.println("Digite o primeiro número: ");
        int num1 = teclado.nextInt();
        System.out.println("Digite o segundo número: ");
        int num2 = teclado.nextInt();
        System.out.println("Resultado: " + soma(num1, num2));
    }
}
