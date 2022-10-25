package banco;



public class Conta {
    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;
    
    public Conta(int agencia, int numero, Cliente cliente){
        this.agencia = agencia ;
        this.numero = numero;
        this.saldo = 0;
        this.cliente = cliente; 
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
}
