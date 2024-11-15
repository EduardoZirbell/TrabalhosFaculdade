package Questao2;

public class App {

    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria();
        ContaBancaria conta2 = new ContaBancaria();
        conta1.setNumero("1");
        conta1.setTitular("Eduardo");
        conta2.setNumero("2");
        conta2.setTitular("Zirbell");
        conta1.depositar(1000);
        conta1.depositar(700);
        conta2.depositar(5000);
        conta2.sacar(3000);
        conta2.transferir(conta1, 1800);
        System.out.println("Dados da 1ª conta: ");
        System.out.println("Número da conta: " + conta1.getNumero());
        System.out.println("Nome do titular: " + conta1.getTitular());
        System.out.println("Saldo da conta: " + conta1.getSaldo());
        System.out.println("Dados da 2ª conta: ");
        System.out.println("Número da conta: " + conta2.getNumero());
        System.out.println("Nome do titular: " + conta2.getTitular());
        System.out.println("Saldo da conta: " + conta2.getSaldo());
    }
}
