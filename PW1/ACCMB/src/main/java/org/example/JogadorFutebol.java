package org.example;
import java.time.LocalDate;
import java.time.Period;

public class JogadorFutebol {
    private String nome;
    private String posicao; // "defesa", "meio-campo" ou "atacante"
    private LocalDate dataNascimento;
    private String nacionalidade;
    private double altura;
    private double peso;

    public void imprimirDados() {
        System.out.println("Nome: " + nome + " | Posição: " + posicao + " | Nacionalidade: " + nacionalidade);
        System.out.println("Altura: " + altura + "m | Peso: " + peso + "kg | Idade: " + calcularIdade() + " anos");
    }

    public int calcularIdade() {
        LocalDate hoje = LocalDate.now();
        if (dataNascimento != null) {
            return Period.between(dataNascimento, hoje).getYears();
        }
        return 0;
    }

    public void tempoAposentadoria() {
        int idade = calcularIdade();
        int idadeAposentadoria = 0;

        if (posicao.equalsIgnoreCase("defesa")) {
            idadeAposentadoria = 40;
        } else if (posicao.equalsIgnoreCase("meio-campo")) {
            idadeAposentadoria = 38;
        } else if (posicao.equalsIgnoreCase("atacante")) {
            idadeAposentadoria = 35;
        } else {
            System.out.println("Posição inválida.");
            return;
        }

        int anosRestantes = idadeAposentadoria - idade;
        if (anosRestantes > 0) {
            System.out.println("Faltam " + anosRestantes + " anos para " + nome + " se aposentar.");
        } else {
            System.out.println(nome + " já tem idade para se aposentar.");
        }
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPosicao() { return posicao; }
    public void setPosicao(String posicao) { this.posicao = posicao; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
}