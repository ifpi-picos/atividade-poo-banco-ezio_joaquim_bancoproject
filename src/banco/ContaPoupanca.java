package banco;

public class ContaPoupanca extends Conta {

    private double rendimento = 0.10;

    public ContaPoupanca(int agencia, int numeroC, Cliente cliente, double rendimento, double saldo,
            Notificacao notificacao) {
        super(agencia, numeroC, saldo, cliente, notificacao);

    }

    public double getRendimento() {
        return rendimento;
    }

    public double setRendimento(double rendimento) {
        return this.rendimento = rendimento;
    }

    public double depositar(double valor) {
        enviaNotificacao("Deposito de: ", valor);
        return super.depositar(valor + (valor * rendimento));
    }

    public double sacar(double valor) {
        return super.sacar(valor);
    }

    public void transferir(Conta destinatario, double valor) {
    double taxa = 0.05;
    saldo -= valor + (valor * taxa);
    destinatario.depositar(valor);
    enviaNotificacao("Transferência realizada: ", valor);
    }
}