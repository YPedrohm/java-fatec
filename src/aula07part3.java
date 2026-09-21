public class aula07part3 {
    public static void main (String[] args) {
        double[] notas = {7.5, 5.0, 8.5, 6.0, 9.0};
        double media = 0;
        int  maiorQueMedia = 0;
        for (int i = 0; i < notas.length; i++) {
            media += notas[i];
        }
        double mediaFinal = media / notas.length;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= mediaFinal) {
                maiorQueMedia ++;
            }
        }
        System.out.println("Média: "+ mediaFinal);
        System.out.println("Notas acima ou iguais à média: " + maiorQueMedia);
    }
}
