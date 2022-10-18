package banco;

public class Endereco {
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private int numero;
    public Endereco(String logradouro, String bairro, String cidade, String uf, int numero){
        this.logradouro = logradouro  ;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf; 
        this.numero = numero;
    }
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
