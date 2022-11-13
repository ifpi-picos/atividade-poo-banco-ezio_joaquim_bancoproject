package banco;

public class ContaCorrente extends Conta{
    private double cheque;
    private int transferenciasRealizadas;
    public ContaCorrente(double saldo,int agencia, int numeroC, Cliente cliente, double cheque, Notificacao notificacao) {
        super(agencia, numeroC, saldo, cliente, notificacao);
        this.cheque = 200;
    }
    public double getCheque() {
        return cheque;
    }

    public double setCheque(double cheque) {
        return this.cheque -= cheque; 
    }

    public double sacar(double valor) {
        return super.sacar(valor);
    }

    public double depositar(double valor){
		
		return super.depositar(valor);
	}
    public void transferir(Conta destinatario, double valor){
        if(transferenciasRealizadas < 2){
        	saldo-= valor;
        	destinatario.depositar(valor);
        	enviaNotificacao("transferência de ", valor);
        	transferenciasRealizadas++;
        
        } else {
        	double taxa = 0.05;
	        saldo -= valor+ (valor * taxa);
	        destinatario.depositar(valor);
	        enviaNotificacao("Transferência realizada com cobrança de taxa: ", valor);
        }
    }
}
