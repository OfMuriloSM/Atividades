package org.example;
public class CartaoDeCredito {
    public double limite;
    public double saldoFatura;
    public String nomeCliente;

    public void aumentaLimite(double valor) {
        this.limite += valor;
    }

    public void diminuiLimite(double valor) {
        this.limite -= valor;
    }

    public boolean realizaCompra(double valorCompra) {
        if ((this.saldoFatura + valorCompra) <= this.limite) {
            this.saldoFatura += valorCompra;
            return true; // Compra aprovada
        } else {
            System.out.println("Compra negada! Limite excedido.");
            return false; // Compra negada
        }
    }

    public void imprimeFatura() {
        System.out.println("--- Fatura de " + nomeCliente + " ---");
        System.out.println("Saldo da Fatura: R$ " + saldoFatura);
        System.out.println("Limite Disponível: R$ " + (limite - saldoFatura));
    }
}