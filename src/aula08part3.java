public class aula08part3 {
    public static void main(String[] args) {
        int somaTodos = 0;
        int contNumPar = 0;
        int somaDiagonal = 0;
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                somaTodos += matriz[i][j];
                if (matriz[i][j] % 2 == 0) {
                    contNumPar++;
                }
                if (i == j) {
                    somaDiagonal += matriz[i][j];
                }
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Soma de todos os elementos: " + somaTodos);
        System.out.println("Soma da diagonal principal: " + somaDiagonal);
        System.out.println("Quantidade de elementos pares: " + contNumPar);
    }
}
