package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=================================");
            System.out.println("      MENU DA ATIVIDADES         ");
            System.out.println("=================================");
            System.out.println("1 - Testar classe Carro");
            System.out.println("2 - Testar classe Cartão de Crédito");
            System.out.println("3 - Testar classe Elevador");
            System.out.println("4 - Testar classe Jogador de Futebol");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Testando CARRO ---");
                    Carro meuCarro = new Carro();
                    meuCarro.nome = "Corolla";
                    meuCarro.peso = 1300.0;
                    meuCarro.fabricante = "Toyota";
                    meuCarro.cor = "Prata";
                    meuCarro.valor = 120000.00;

                    System.out.println("ANTES:");
                    System.out.println("Cor: " + meuCarro.cor + " | Preço: R$ " + meuCarro.valor);

                    meuCarro.pintar("Preto");
                    meuCarro.darDesconto(10);

                    System.out.println("DEPOIS:");
                    System.out.println("Cor: " + meuCarro.cor + " | Preço: R$ " + meuCarro.valor);
                    break;

                case 2:
                    System.out.println("\n--- Testando CARTÃO DE CRÉDITO ---");
                    CartaoDeCredito cartao = new CartaoDeCredito();
                    cartao.nomeCliente = "Maria";
                    cartao.limite = 2000.00;
                    cartao.saldoFatura = 500.00;

                    cartao.imprimeFatura();
                    System.out.println("Tentando comprar algo de R$ 1000.00...");
                    cartao.realizaCompra(1000.00);

                    System.out.println("Tentando comprar algo de R$ 800.00...");
                    cartao.realizaCompra(800.00);
                    System.out.println("\nFatura final:");
                    cartao.imprimeFatura();
                    break;

                case 3:
                    System.out.println("\n--- Testando ELEVADOR ---");
                    Elevador elevador = new Elevador();
                    elevador.inicializa(5, 10);

                    System.out.println("Andar atual: " + elevador.getAndarAtual() + " | Pessoas: " + elevador.getPessoasPresentes());

                    elevador.entra();
                    elevador.entra();
                    System.out.println("Duas pessoas entraram. Pessoas presentes: " + elevador.getPessoasPresentes());

                    elevador.sobe();
                    elevador.sobe();
                    System.out.println("Subimos dois andares. Andar atual: " + elevador.getAndarAtual());

                    elevador.sai();
                    System.out.println("Uma pessoa saiu. Pessoas presentes: " + elevador.getPessoasPresentes());
                    break;

                case 4:
                    System.out.println("\n--- Testando JOGADOR DE FUTEBOL ---");
                    JogadorFutebol jogador = new JogadorFutebol();
                    jogador.setNome("Ronaldo Fenômeno");
                    jogador.setPosicao("atacante");
                    jogador.setDataNascimento(LocalDate.of(1976, 9, 18));
                    jogador.setNacionalidade("Brasileiro");
                    jogador.setAltura(1.83);
                    jogador.setPeso(82.0);

                    jogador.imprimirDados();
                    jogador.tempoAposentadoria();
                    break;

                case 0:
                    System.out.println("\nSaindo do programa... Até a próxima!");
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}