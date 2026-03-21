package org.example;

public class Vendedor extends Empregado {
    private double valorVendas;
    private double comissao;

    public Vendedor(String nome, int codigoSetor, double salarioBase, double imposto, double valorVendas, double comissao) {
        super(nome, codigoSetor, salarioBase, imposto);
        this.valorVendas = valorVendas;
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario() {
        double valorComissao = this.valorVendas * (this.comissao / 100);
        return super.calcularSalario() + valorComissao;
    }

    public double getValorVendas() { return valorVendas; }
    public void setValorVendas(double valorVendas) { this.valorVendas = valorVendas; }

    public double getComissao() { return comissao; }
    public void setComissao(double comissao) { this.comissao = comissao; }
}