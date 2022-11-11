package banco;

public class ContaCorrente extends Conta{
    private double cheque;
    public ContaCorrente(double saldo,int agencia, int numeroC, Cliente cliente, double cheque, Notificacao notificacao) {
        super(agencia, numeroC, saldo, cliente, notificacao);
        this.cheque = cheque;
    }
    public double getCheque() {
        return cheque;
    }

    public double setCheque(double cheque) {
        return this.cheque -= cheque; 
    }

}
