package org.example;

public class Operario extends Empregado {
    private double valorProducao;
    private double comissao;

    public Operario(String nome, int codigoSetor, double salarioBase, double imposto, double valorProducao, double comissao) {
        super(nome, codigoSetor, salarioBase, imposto);
        this.valorProducao = valorProducao;
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario() {
        double valorComissao = this.valorProducao * (this.comissao / 100);
        return super.calcularSalario() + valorComissao;
    }

    public double getValorProducao() { return valorProducao; }
    public void setValorProducao(double valorProducao) { this.valorProducao = valorProducao; }

    public double getComissao() { return comissao; }
    public void setComissao(double comissao) { this.comissao = comissao; }
}