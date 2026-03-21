package org.example;

public class Administrador extends Empregado {
    private double ajudaDeCusto;

    public Administrador(String nome, int codigoSetor, double salarioBase, double imposto, double ajudaDeCusto) {
        super(nome, codigoSetor, salarioBase, imposto);
        this.ajudaDeCusto = ajudaDeCusto;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + this.ajudaDeCusto;
    }

    public double getAjudaDeCusto() { return ajudaDeCusto; }
    public void setAjudaDeCusto(double ajudaDeCusto) { this.ajudaDeCusto = ajudaDeCusto; }
}