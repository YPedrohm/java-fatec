public class aula06part2 {
    public static void main (String[] args) {
        double ValorCarro = 30000;
        for (int parcela = 1; parcela < ValorCarro; parcela ++) {
            double valorparcela = ValorCarro / parcela;
            if (valorparcela >= 1000) {
                System.out.println("Parcela " + parcela + " R$" + valorparcela);
            }
            else {
                break;
            }
        }
    }
}