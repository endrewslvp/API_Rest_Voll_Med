package med.voll.api.endereco;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

    //Atributes ---------------------------------------------
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    //Getters ---------------------------------------------
    public String getLogradouro() {return logradouro;}
    public String getBairro() {return bairro;}
    public String getCep() { return cep;}
    public String getNumero() {return numero;}
    public String getComplemento() { return complemento;}
    public String getCidade() {return cidade;}
    public String getUf() {return uf;}

    //Setters ---------------------------------------------
    public void setLogradouro(String logradouro) {this.logradouro = logradouro;}
    public void setBairro(String bairro) {this.bairro = bairro;}
    public void setCep(String cep) {this.cep = cep;}
    public void setNumero(String numero) {this.numero = numero;}
    public void setComplemento(String complemento) {this.complemento = complemento;}
    public void setCidade(String cidade) {this.cidade = cidade;}
    public void setUf(String uf) {this.uf = uf;}

    public Endereco(String logradouro, String bairro, String cep, String numero, String complemento, String cidade, String uf) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Endereco(EnderecoDTO dados){
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public Endereco() {}

}
