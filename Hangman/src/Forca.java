import java.util.Random;
import java.util.Scanner;

public class Forca {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random aleatorio = new Random();

        String[] listaPalavras = {
            "java",
            "python",
            "programacao",
            "computador",
            "desenvolvimento",
            "algoritmo",
            "internet",
            "teclado",
            "monitor",
            "celular",
            "tecnologia",
            "software",
            "hardware",
            "programador",
            "engenharia",
            "faculdade",
            "universidade",
            "professor",
            "estudante",
            "biblioteca",
            "matematica",
            "portugues",
            "historia",
            "geografia",
            "ciencia",
            "astronomia",
            "planeta",
            "universo",
            "galaxia",
            "elefante",
            "cachorro",
            "gato",
            "passarinho",
            "borboleta",
            "tartaruga",
            "crocodilo",
            "girafa",
            "macaco",
            "leao",
            "tigre",
            "cavalo",
            "coelho",
            "abacaxi",
            "banana",
            "morango",
            "laranja",
            "melancia",
            "chocolate",
            "sorvete",
            "hamburguer",
            "pizza",
            "bicicleta",
            "motocicleta",
            "automovel",
            "aviao",
            "helicoptero",
            "navio",
            "futebol",
            "basquete",
            "voleibol",
            "natacao",
            "atletismo",
            "academia",
            "musica",
            "violao",
            "guitarra",
            "piano",
            "bateria",
            "cinema",
            "filme",
            "teatro",
            "fotografia",
            "viagem",
            "aventura",
            "praia",
            "montanha",
            "floresta",
            "cachoeira",
            "restaurante",
            "churrasco",
            "familia",
            "amizade",
            "felicidade",
            "esperanca",
            "liberdade",
            "conhecimento",
            "criatividade",
            "inteligencia",
            "curiosidade",
            "responsabilidade",
            "oportunidade",
            "experiencia",
            "aprendizado",
            "desafio",
            "vitoria"
        };

        String[] estagios = {
            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            "/|\\  |\n" +
            "/ \\  |\n" +
            "     |\n" +
            "=========\n",

            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            "/|\\  |\n" +
            "/    |\n" +
            "     |\n" +
            "=========\n",

            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            "/|\\  |\n" +
            "     |\n" +
            "     |\n" +
            "=========\n",

            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            "/|   |\n" +
            "     |\n" +
            "     |\n" +
            "=========\n",

            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            " |   |\n" +
            "     |\n" +
            "     |\n" +
            "=========\n",

            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            "     |\n" +
            "     |\n" +
            "     |\n" +
            "=========\n",

            " +---+\n" +
            " |   |\n" +
            "     |\n" +
            "     |\n" +
            "     |\n" +
            "     |\n" +
            "=========\n"
        };

        int vidas = 6;

        String palavraEscolhida =
            listaPalavras[aleatorio.nextInt(listaPalavras.length)%listaPalavras.length];

        String palavraAtual = "";

        for (int i = 0; i < palavraEscolhida.length(); i++) {
            palavraAtual += "_";
        }

        String letrasTentadas = "";
        boolean jogoTerminou = false;

        System.out.println("================================");
        System.out.println("          JOGO DA FORCA");
        System.out.println("================================");
        System.out.println("Palavra: " + palavraAtual);

        while (!jogoTerminou) {

            System.out.println();
            System.out.println(
                "******** " + vidas + "/6 VIDAS ********"
            );

            System.out.print("Digite uma letra: ");
            String entrada = scanner.nextLine().toLowerCase();

            if (entrada.length() == 0) {
                System.out.println("Digite uma letra!");
                continue;
            }

            char letraEscolhida = entrada.charAt(0);

            if (letrasTentadas.indexOf(letraEscolhida) != -1) {
                System.out.println("Você já tentou essa letra!");
                continue;
            }

            boolean acertou = false;
            String novaPalavra = "";

            for (int i = 0; i < palavraEscolhida.length(); i++) {
                char letraAtual = palavraEscolhida.charAt(i);

                if (letraAtual == letraEscolhida) {
                    novaPalavra += letraAtual;
                    acertou = true;

                } else {
                    novaPalavra += palavraAtual.charAt(i);
                }
            }
            palavraAtual = novaPalavra;

            System.out.println("Palavra: " + palavraAtual);

            if (!acertou) {

                vidas--;

                System.out.println(
                    "A letra '" + letraEscolhida +
                    "' não está na palavra!"
                );

                System.out.println("Você perdeu uma vida!");
            }
            if (palavraAtual.indexOf('_') == -1) {
                jogoTerminou = true;

                System.out.println();
                System.out.println("************************");
                System.out.println("      VOCÊ VENCEU!");
                System.out.println("************************");
                System.out.println(
                    "Parabéns! A palavra era: " + palavraEscolhida
                );
            }
            if (vidas == 0) {

                jogoTerminou = true;

                System.out.println();
                System.out.println("************************");
                System.out.println("      VOCÊ PERDEU!");
                System.out.println("************************");
                System.out.println(
                    "A palavra era: " + palavraEscolhida
                );
            }
            System.out.println(estagios[vidas]);
        }
        scanner.close();
    }
}