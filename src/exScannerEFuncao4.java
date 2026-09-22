import java.util.Scanner;

public class exScannerEFuncao4 {
    static int maiorNumero(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    public static void main (String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o primeiro número: ");
        int num1 = teclado.nextInt();
        System.out.println("Digite o segundo número: ");
        int num2 = teclado.nextInt();
        System.out.println("maior número: " + maiorNumero(num1, num2));
    }
}
