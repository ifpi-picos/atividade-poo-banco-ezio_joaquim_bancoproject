import java.time.LocalDate;

import banco.Cliente;
import banco.Conta;
import banco.Endereco;

public class App {
    public static void main(String[] args) throws Exception {
        Endereco endereco = new Endereco("xxx", "junco", "Picos", "pi", 160);
        Cliente cliente = new Cliente("junior", "19", LocalDate.of(2001, 4, 10), null);
        Conta conta = new Conta(88, 7, null);
        
    }
}
