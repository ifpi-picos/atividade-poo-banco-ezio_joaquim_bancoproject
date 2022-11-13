import banco.Cliente;
import banco.ContaCorrente;
import banco.ContaPoupanca;
import banco.Email;
import banco.Endereco;
import banco.Sms;
import java.time.LocalDate;

public class App {
  public static void main(String[] args) {

    Endereco endereco = new Endereco("fue", "asd", "asdas", "sdas", 100);
    Cliente cliente = new Cliente("aaaaa", "07917870367", LocalDate.of(2001, 9, 10), endereco);
    ContaCorrente contaCorrente = new ContaCorrente(1000, 1919, 1431, cliente, 1000, new Email());
    ContaPoupanca contaPoupanca = new ContaPoupanca(0123, 1234, cliente, 199, 12333, new Sms());
    contaPoupanca.depositar(1000);
    contaPoupanca.transferir(500.00, contaCorrente);
    contaCorrente.transferir(200.00, contaPoupanca);
    
  }
}
