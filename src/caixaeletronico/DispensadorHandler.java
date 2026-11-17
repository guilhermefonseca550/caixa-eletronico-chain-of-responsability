package caixaeletronico;


public abstract class DispensadorHandler {
    protected DispensadorHandler proximoElo;
    protected final int valorNota;

    public DispensadorHandler(int valorNota) {
        this.valorNota = valorNota;
    }


    public DispensadorHandler definirProximo(DispensadorHandler proximoElo) {
        this.proximoElo = proximoElo;
        return proximoElo;
    }


    public void dispensar(int valor) {
        if (valor >= valorNota) {
            int quantidadeNotas = valor / valorNota;
            int restante = valor % valorNota;

            System.out.printf("  -> Entregando %d nota(s) de R$ %d,00%n", quantidadeNotas, valorNota);

            if (restante > 0 && proximoElo != null) {
                proximoElo.dispensar(restante);
            }
        } else if (valor > 0 && proximoElo != null) {
            proximoElo.dispensar(valor);
        }
    }
}
