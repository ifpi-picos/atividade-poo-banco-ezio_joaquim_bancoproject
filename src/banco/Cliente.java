package banco;
// import java.sql.Date;
import java.time.LocalDate;


public class Cliente {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Endereco endereco;
    
    public Cliente(String nome, String cpf, LocalDate dataNascimento, Endereco endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }


    public String getCpf() {
        return cpf;   
    }
    
    public String getNome() {
        return nome;  
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    
    public Endereco getEndereco() {
        return endereco;
    }
    public String toString() {
        return "[" + this.getCpf() + ", " 
                   + this.getNome() + ", " 
                   + this.getDataNascimento() + ", " 
                   + this.getEndereco() + "]";
                   
    }    
}
