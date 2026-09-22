import java.util.Scanner;

public class exScannerEFuncao3 {
    static double calcularMedia(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }
    public static void main (String[] args) {
        Scanner teclado = new Scanner(System.in);
        int [] nota = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Digite o " + (i+1) + "º numero: ");
            nota[i] = teclado.nextInt();
        }
        System.out.println("A média é: " + calcularMedia(nota[0],nota[1],nota[2]));
    }
}
