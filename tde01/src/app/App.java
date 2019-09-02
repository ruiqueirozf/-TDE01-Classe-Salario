package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        Salario sal1 = new Salario(5000.0);
        System.out.println(sal1.getSalarioLiquido());
    }
}