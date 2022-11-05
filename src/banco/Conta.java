package banco;

public class Conta {
    private int agencia;
    private int numeroC;
    protected double saldo;
    private Cliente cliente;
    private Notificacao notificacao;

    public Conta(int agencia, int numeroC, double saldo, Cliente cliente, Notificacao notificacao) {
        this.agencia = agencia;
        this.numeroC = numeroC;
        this.saldo = 0;
        this.cliente = cliente;
        this.notificacao = notificacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroC() {
        return numeroC;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double saldo) {
        this.saldo += saldo;
        return true;
    }

    public Notificacao getNotificacao() {
        return this.notificacao;
    }

    public double sacar(double saldo) {
        this.saldo -= saldo;
        return saldo;
    }

    public void transferir(double saldo, Conta destinatario) {
        this.saldo -= saldo;
        destinatario.saldo += saldo;
    }

    public void enviarNotificacao(String operacao, double valor) {
        this.notificacao.enviaNotificacao(operacao, valor);
    }
}
