package banco;

import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Endereco end = new Endereco();
    public Cliente(String nome, String cpf, LocalDate dn, Endereco end){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dn;
        this.end = end;
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

}
