package org.example;
public class Carro {
    public String nome;
    public double peso;
    public String fabricante;
    public String cor;
    public double valor;

    public void darDesconto(double porcentagem) {
        double desconto = this.valor * (porcentagem / 100);
        this.valor -= desconto;
    }

    public void pintar(String novaCor) {
        this.cor = novaCor;
    }
}