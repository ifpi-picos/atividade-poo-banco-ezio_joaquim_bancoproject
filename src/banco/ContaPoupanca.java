package banco;

public class ContaPoupanca extends Conta{

    private double rendimento;
    public ContaPoupanca(int agencia, int numeroC, Cliente cliente, double rendimento,double saldo, Notificacao notificacao) {
        super(agencia, numeroC, saldo, cliente, notificacao);
        
    }
    public double getRendimento() {
        return rendimento;
    }
    public double setRendimento(double rendimento) {
        return this.rendimento = rendimento;
    }
    
}