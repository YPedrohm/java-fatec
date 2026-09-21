public class Aula08part2 {
    public static void main(String[] args) {
        double[] notas = {7.5, 6.0, 8.5, 5.0, 9.0, 6.5, 7.0, 8.0};
        double mediaNota = 0;
        double somaNotas = 0;
        double maiorNota = 0;
        int maiorOuIgualMedia = 0;
        for (int i = 0; i < notas.length; i++) {
            somaNotas += notas[i];
            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
            }
        }
        mediaNota = somaNotas / notas.length;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= mediaNota) {
                maiorOuIgualMedia++;
            }
        }
        System.out.println("Média: " + mediaNota);
        System.out.println("Quantidade de notas maiores que a média: " + maiorOuIgualMedia);
        System.out.println("Maior nota: " + maiorNota);
    }
}