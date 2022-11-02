package banco;
import java.util.List;
// import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private List<Endereco> enderecos = new ArrayList<>();
    
    public Cliente(String nome, String cpf, LocalDate dataNascimento, Endereco endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.enderecos.add(endereco);
    }


    public String getCpf() {
        return cpf;   
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;   
    }
    
    public String getNome() {
        return nome;  
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public List<Endereco> getEnderecos() {
        return enderecos;
    }
    
    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }
    
    
    public void removeEndereco(Endereco endereco) {
        this.enderecos.remove(endereco);
    }
}
