package org.example;
public class Elevador {
    private int andarAtual;
    private int totalAndares;
    private int capacidade;
    private int pessoasPresentes;

    public void inicializa(int capacidade, int totalAndares) {
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0;
        this.pessoasPresentes = 0;
    }

    public void entra() {
        if (this.pessoasPresentes < this.capacidade) {
            this.pessoasPresentes++;
        } else {
            System.out.println("Elevador lotado!");
        }
    }

    public void sai() {
        if (this.pessoasPresentes > 0) {
            this.pessoasPresentes--;
        } else {
            System.out.println("Elevador já está vazio!");
        }
    }

    public void sobe() {
        if (this.andarAtual < this.totalAndares) {
            this.andarAtual++;
        } else {
            System.out.println("Já estamos no último andar!");
        }
    }

    public void desce() {
        if (this.andarAtual > 0) {
            this.andarAtual--;
        } else {
            System.out.println("Já estamos no térreo!");
        }
    }

    public int getAndarAtual() { return andarAtual; }
    public void setAndarAtual(int andarAtual) { this.andarAtual = andarAtual; }

    public int getTotalAndares() { return totalAndares; }
    public void setTotalAndares(int totalAndares) { this.totalAndares = totalAndares; }

    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    public int getPessoasPresentes() { return pessoasPresentes; }
    public void setPessoasPresentes(int pessoasPresentes) { this.pessoasPresentes = pessoasPresentes; }
}