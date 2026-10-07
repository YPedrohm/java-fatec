import java.util.Scanner;

public class Main {

    static int[][] torres = new int[3][10];
    static int[] topos = new int[3];
    static int discos;

    static void desenhar() {
        int largura = discos * 2 + 1;
        String separador = "=".repeat(largura * 3 + 6);

        System.out.println("\n" + separador);

        for (int linha = discos - 1; linha >= 0; linha--) {
            for (int t = 0; t < 3; t++) {
                System.out.print(desenharDisco(torres[t][linha]) + "   ");
            }
            System.out.println();
        }

        for (int t = 0; t < 3; t++) {
            System.out.print(" ".repeat(discos) + (char) ('A' + t) + " ".repeat(discos) + "   ");
        }
        System.out.println("\n" + separador + "\n");
    }

    static String desenharDisco(int disco) {
        if (disco == 0) {
            return " ".repeat(discos) + "|" + " ".repeat(discos);
        }
        int espacos = discos - disco + 1;
        return " ".repeat(espacos) + "=".repeat(disco * 2 - 1) + " ".repeat(espacos);
    }

    static boolean mover(int origem, int destino) {
        if (origem == destino) {
            System.out.println(">> Origem e destino são a mesma torre.");
            return false;
        }

        if (topos[origem] == 0) {
            System.out.println(">> A torre " + (char) ('A' + origem) + " está vazia.");
            return false;
        }

        int disco = torres[origem][topos[origem] - 1];

        if (topos[destino] > 0 && torres[destino][topos[destino] - 1] < disco) {
            System.out.println(">> Não pode colocar um disco maior sobre um menor.");
            return false;
        }

        topos[origem]--;
        torres[origem][topos[origem]] = 0;
        torres[destino][topos[destino]++] = disco;

        System.out.println("Movendo disco " + disco + " de "
                + (char) ('A' + origem) + " para " + (char) ('A' + destino));
        return true;
    }

    static int indice(char letra) {
        if (letra >= 'A' && letra <= 'C')
            return letra - 'A';
        return -1;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a quantidade de discos (1 a 10): "); // FAZ O IF LUANNNNNNNNNNNNNNNN
        try {
            discos = Integer.parseInt(entrada.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
            return;
        }

        if (discos < 1 || discos > 10) {
            System.out.println("Quantidade inválida.");
            return;
        }

        for (int i = discos; i >= 1; i--)
            torres[0][topos[0]++] = i;

        System.out.println("\nTORRE DE HANOI");
        desenhar();

        int movimentos = 0;

        while (topos[2] < discos) {
            System.out.print("Movimento " + (movimentos + 1) + ": ");

            if (!entrada.hasNextLine())
                break;

            String linha = entrada.nextLine().replace(" ", "").toUpperCase();

            if (linha.equals("S")) {
                System.out.println("Jogo encerrado. Até a próxima!");
                return;
            }

            if (linha.length() != 2) {
                System.out.println(">> Formato inválido. Use, por exemplo: A C");
                continue;
            }

            int origem = indice(linha.charAt(0));
            int destino = indice(linha.charAt(1));

            if (origem == -1 || destino == -1) {
                System.out.println(">> Use apenas as torres A, B ou C.");
                continue;
            }

            if (mover(origem, destino)) {
                movimentos++;
                desenhar();
            }
        }

        if (topos[2] == discos) {

            System.out.println("================================");
            System.out.println("    PARABÉNS, VOCÊ VENCEU!");
            System.out.println("================================");
            System.out.println("Seus movimentos: " + movimentos);
        }

        entrada.close();
    }
}