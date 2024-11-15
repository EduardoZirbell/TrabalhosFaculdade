package Questao2;

public class ContaBancaria {
    
    private String numero;
    private String titular;
    private double saldo;
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String getTitular() {
        return titular;
    }
    
    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor para deposito inválido.");
        }
        setSaldo(getSaldo() + valor);
    }
    
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor para saque inválido.");
        }
        if (valor > getSaldo()) {
            throw new IllegalArgumentException("Valor para saque inválido.");
        }
        setSaldo(getSaldo() - valor);
    }
    
    public void transferir(ContaBancaria contaDestino, double valor) {
        sacar(valor);
        contaDestino.depositar(valor);
    }
}
