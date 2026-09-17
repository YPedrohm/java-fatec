public class Aula05EstruturaCondicionais {
    static void main(String[] args) {
    int salario = 5000;
    if (salario < 34712){
        double tax = salario * (9.7 / 100);
        System.out.println("Você vai ter que pagar R$: "+ tax + " de taxa");
    } else if (salario >= 34712 && salario < 68507) {
        double tax = salario * (37.35 / 100);
        System.out.println("Você vai ter que pagar R$: "+ tax + " de taxa");
    }else {
        double tax = salario * (49.50 / 100);
        System.out.println("Você vai ter que pagar R$: "+ tax + " de taxa");
    }
    }
}
