package caixaeletronico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CaixaEletronico caixa = new CaixaEletronico();
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================");
        System.out.println("   CAIXA ELETRÔNICO - CHAIN OF RESPONSIBILITY");
        System.out.println("   Notas disponíveis: R$ 100, R$ 50, R$ 20, R$ 10");
        System.out.println("============================================");

        while (true) {
            System.out.print("\nDigite o valor para saque (ou 0 para sair): R$ ");
            String entrada = scanner.nextLine().trim();

            int valor;
            try {
                valor = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                continue;
            }

            if (valor == 0) {
                System.out.println("Encerrando o Caixa Eletrônico. Até logo!");
                break;
            }

            caixa.sacar(valor);
        }

        scanner.close();
    }
}
