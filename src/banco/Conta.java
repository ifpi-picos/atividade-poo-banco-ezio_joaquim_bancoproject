package banco;

public class Conta {
    private int agencia;
    private int numero;
    protected double saldo;
    private Cliente cliente;
    private Notificacao notificacao;

    public Conta(int agencia, int numero, Cliente cliente, Notificacao notificacao) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0;
        this.cliente = cliente;
        this.notificacao = notificacao;
    }

    public Conta(int agencia2, int numero2, Cliente cliente2, Notificacao notificacao2, double saldo2) {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Notificacao getNotificacao() {
        return this.notificacao;
    }

    public double sacar(double saldo) {
        this.saldo -= saldo;
        return saldo;
    }
}
