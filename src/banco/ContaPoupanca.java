package banco;

public class ContaPoupanca extends Conta{

    private double rendimento;
    public ContaPoupanca(int agencia, int numero, Cliente cliente, double rendimento, Notificacao notificacao) {
        super(agencia, numero, cliente, notificacao);
        
    }
    public double getRendimento() {
        return rendimento;
    }
    public double setRendimento(double rendimento) {
        return this.rendimento = rendimento;
    }
    public String toString() {
        return "[" + this.getAgencia() + ", " 
                   + this.getNumero() + ", "
                   + this.getSaldo() + ", "
                   + this.getCliente() + ", "
                   + this.getNotificacao() + ", "
                   + this.getRendimento() + "]";
    }
    
}