package banco;

import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public Cliente(String nome, String cpf, LocalDate dn){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dn;
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
