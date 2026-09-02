import java.util.Scanner;

public class App {
    static String[] nomes = new String[4];
    static String[] cidades = new String[4];
    static String[] paises = new String[4];

    static float[] viagens = new float[4];
    static float[] restaurante = new float[4];
    static float[] totalViagem = new float[4];

    static float total = 0;
    static float media = 0;

    static int eua = 0, alemanha = 0, portugal = 0, brasil = 0;

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        for (int posicao = 0; posicao < nomes.length; posicao++) {

            System.out.println("Digite o nome do viajante: ");
            nomes[posicao] = teclado.nextLine();

            System.out.println("Qual cidade você visitou? ");
            cidades[posicao] = teclado.nextLine();

            System.out.println("Qual pais você visitou? ");
            paises[posicao] = teclado.nextLine();

            String aux = paises[posicao].toUpperCase();

            if (aux.equals("EUA")) {
                eua++;
            } else {
                if (aux.equals("ALEMANHA")) {
                    alemanha++;
                } else {
                    if (aux.equals("PORTUGAL")) {
                        portugal++;
                    } else {
                        if (aux.equals("BRASIL")) {
                            brasil++;
                        }
                    }
                }
            }

            System.out.println("Digite o valor da viagem: ");
            viagens[posicao] = teclado.nextFloat();

            System.out.println("Qual o valor gasto em restaurante? ");
            restaurante[posicao] = teclado.nextFloat();

            totalViagem[posicao] = viagens[posicao] + restaurante[posicao];

            total += restaurante[posicao];

            teclado.nextLine();
        }

        media = total / nomes.length;

        String mensagem = "";

        for (int posicao = 0; posicao < nomes.length; posicao++) {

            if (totalViagem[posicao] <= 15000) {
    mensagem = "Viagem com custo razoável";
} else {
    if (totalViagem[posicao] <= 28000) {
        mensagem = "Viagem de alto custo";
    } else {
        mensagem = "Viagem com custo altíssimo";
    }
}
            System.out.println("Nome: " + nomes[posicao]);
            System.out.println("Cidade: " + cidades[posicao]);
            System.out.println("Pais visitado: " + paises[posicao]);
            System.out.println("Restaurante: " + restaurante[posicao]);
            System.out.println("Total da viagem: " + totalViagem[posicao]);
            System.out.println(mensagem);
            System.out.println("-------------------------");
        }

        System.out.println("Total gasto em restaurantes: " + total);
        System.out.println("Média gasta em restaurantes: " + media);
        System.out.println("EUA: " + eua);
        System.out.println("Alemanha: " + alemanha);
        System.out.println("Portugal: " + portugal);
        System.out.println("Brasil: " + brasil);
    }
}