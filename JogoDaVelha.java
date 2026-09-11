import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        char[][] tabuleiro = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        char jogadorAtual = 'X';
        boolean JogoEmAndamento = true;
        Scanner scanner = new Scanner(System.in);
        int jogadas = 0;

        while (JogoEmAndamento) {
            imprimirTabuleiro(tabuleiro);
            System.out.println("Vez do jogador " + jogadorAtual + ". Digite a linha (0-2) e coluna (0-2): ");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogadorAtual;
                jogadas++;

                if (verificarVitoria(tabuleiro, jogadorAtual)) {
                    imprimirTabuleiro(tabuleiro);
                    System.out.println("Jogador " + jogadorAtual + " venceu!");
                    JogoEmAndamento = false;
                } else if (jogadas == 9) {
                    imprimirTabuleiro(tabuleiro);
                    System.out.println("Empate!");
                    JogoEmAndamento = false;
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Jogada inválida! Tente novamente.");
            }
        }
        scanner.close();
    }

    public static void imprimirTabuleiro(char[][] t) {
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " " + t[i][0] + " | " + t[i][1] + " | " + t[i][2]);
            System.out.println();
            if (i < 2) System.out.println(" ------+---+---");
        }
    }

    public static boolean verificarVitoria(char[][] t, char j) {
        for (int i = 0; i < 3; i++) {
            if (t[i][0] == j && t[i][1] == j && t[i][2] == j) return true;
            if (t[0][i] == j && t[1][i] == j && t[2][i] == j) return true;
        }
        if (t[0][0] == j && t[1][1] == j && t[2][2] == j) return true;
        if (t[0][2] == j && t[1][1] == j && t[2][0] == j) return true;
        return false;
    }
}