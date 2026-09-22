import java.util.Scanner;
public class exScannerEFuncao {
    public static void saudacao (String name) {
        System.out.println("Olá, " + name + "! Seja bem-vindo(a) ao programa.");
    }
    public static void main (String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Qual é o seu nome?");
        String nome = teclado.nextLine();
        saudacao(nome);
    }
}
