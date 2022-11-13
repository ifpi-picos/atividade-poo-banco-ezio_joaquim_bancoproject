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
        this.saldo = saldo;
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

    public double depositar(double valor) {
        this.saldo = saldo + valor;
        return saldo;
    }

    public Notificacao getNotificacao() {
        return this.notificacao;
    }
    
    public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

    public double sacar(double valor) {
        if (valor < saldo) {
        this.saldo = saldo - valor;
        enviaNotificacao("Saque efetuado no valor de: ", valor);
        } else {
            System.out.println("Valor de saque excede seu saldo!");
        }
        return saldo;
    }

    public void transferir(Double valor, Conta destinatario) {
        this.sacar(valor);
        destinatario.depositar(valor);
        enviaNotificacao("Deposito efetuado: ", valor);
    }

    public void enviaNotificacao(String operacao, Double valor) {
        this.notificacao.enviaNotificacao(operacao, valor);
    }
}
