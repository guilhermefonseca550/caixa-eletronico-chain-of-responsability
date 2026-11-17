package caixaeletronico;


public class CaixaEletronico {
    private final DispensadorHandler primeiroElo;

    public CaixaEletronico() {

        DispensadorHandler nota100 = new DispensadorNota100();
        DispensadorHandler nota50 = new DispensadorNota50();
        DispensadorHandler nota20 = new DispensadorNota20();
        DispensadorHandler nota10 = new DispensadorNota10();


        nota100.definirProximo(nota50)
               .definirProximo(nota20)
               .definirProximo(nota10);

        this.primeiroElo = nota100;
    }

    public void sacar(int valor) {
        System.out.println("\n--------------------------------------------");
        System.out.printf("Solicitação de saque: R$ %d,00%n", valor);

        if (valor <= 0) {
            System.out.println("Erro: O valor do saque deve ser maior que zero.");
            return;
        }

        if (valor % 10 != 0) {
            System.out.println("Erro: Valor inválido! O caixa possui apenas notas de R$ 100, R$ 50, R$ 20 e R$ 10 (digite um múltiplo de 10).");
            return;
        }

        System.out.println("Contando cédulas:");
        primeiroElo.dispensar(valor);
        System.out.println("Saque concluído com sucesso!");
        System.out.println("--------------------------------------------");
    }
}
