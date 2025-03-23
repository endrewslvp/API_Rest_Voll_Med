package med.voll.api.medico;

import jakarta.persistence.*;
import med.voll.api.endereco.Endereco;
import java.util.Objects;

@Table(name = "Medico")
@Entity
public class Medico {

    //Atributes ---------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    //Getters ---------------------------------------------
    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getTelefone(){return telefone;}
    public String getCrm() {return crm;}
    public Especialidade getEspecialidade() {return especialidade;}
    public Endereco getEndereco() {return endereco;}

    //Setters ---------------------------------------------
    public void setId(Long id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setEmail(String email) {this.email = email;}
    public void setTelefone(String telefone){this.telefone = telefone;}
    public void setCrm(String crm) {this.crm = crm;}
    public void setEspecialidade(Especialidade especcialidade) {this.especialidade = especcialidade;}
    public void setEndereco(Endereco endereco) {this.endereco = endereco;}

    //Construtores ---------------------------------------------
    public Medico(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public Medico (MedicoDTO dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public Medico() {}

    //Equals and HaschCode for Id ---------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(id, medico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
