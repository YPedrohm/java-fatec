import java.util.Scanner;

public class exScannerEFuncao6 {
    static String aprovacao(int a, int b, int c) {
        double media = (a + b + c) / 3.0;
        if (media >= 7) {
            return "Aprovado!";
        } else if (media >= 5) {
            return "Recuperação!";
        } else {
            return "Reprovado!";
        }
    }
    public static void main (String[] args) {
        Scanner teclado = new Scanner(System.in);
        int [] notas = new int[3];
        System.out.println("Digite o nome do aluno: ");
        String nome = teclado.nextLine();
        for (int i = 0; i < 3; i++) {
            System.out.println("Digite a " + (i+1) + "º nota: ");
            notas[i] = teclado.nextInt();
        }
        System.out.println("O aluno: " + nome + " está " + aprovacao(notas[0], notas[1], notas[2]));
    }
}
