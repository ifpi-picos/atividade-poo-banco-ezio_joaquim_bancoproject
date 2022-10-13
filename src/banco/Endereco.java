package banco;

public class Endereco {
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private int numero;

    public String getBairro() {
        return bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public int getNumero() {
        return numero;
    }
    public String getUf() {
        return uf;
    }
}
