package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Teste Fornecedor ---");
        Fornecedor fornecedor = new Fornecedor("Tech Peças", 5000.0, 1500.0);
        System.out.println("Fornecedor: " + fornecedor.getNome());
        System.out.println("Saldo: R$ " + fornecedor.obterSaldo());

        System.out.println("\n--- Teste Empregado ---");
        Empregado empregado = new Empregado("João", 1, 2000.0, 10.0); // 10% de imposto
        System.out.println("Empregado: " + empregado.getNome());
        System.out.println("Salário Líquido: R$ " + empregado.calcularSalario());

        System.out.println("\n--- Teste Administrador ---");
        Administrador admin = new Administrador("Ana", 2, 4000.0, 15.0, 1000.0); // 15% imposto, R$1000 ajuda de custo
        System.out.println("Administrador: " + admin.getNome());
        System.out.println("Salário Final: R$ " + admin.calcularSalario());

        System.out.println("\n--- Teste Operario ---");
        Operario operario = new Operario("Carlos", 3, 1500.0, 5.0, 5000.0, 5.0); // Produziu R$5000, 5% de comissão
        System.out.println("Operário: " + operario.getNome());
        System.out.println("Salário Final: R$ " + operario.calcularSalario());

        System.out.println("\n--- Teste Vendedor ---");
        Vendedor vendedor = new Vendedor("Mariana", 4, 1800.0, 8.0, 10000.0, 2.0); // Vendeu R$10000, 2% de comissão
        System.out.println("Vendedor: " + vendedor.getNome());
        System.out.println("Salário Final: R$ " + vendedor.calcularSalario());
    }
}