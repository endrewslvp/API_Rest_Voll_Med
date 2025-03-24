package med.voll.api.paciente.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.paciente.DTO.PacienteDTO;
import med.voll.api.paciente.DTO.PacienteUpdateDTO;

import java.util.Objects;

@Table(name = "paciente")
@Entity
public class Paciente {

    //Atributes -------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    //Getters -------------------------------
    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getTelefone() {return telefone;}
    public String getCpf() {return cpf;}
    public Endereco getEndereco() {return endereco;}
    public Boolean getAtivo(){return ativo;}

    //Setters -------------------------------
    public void setId(Long id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setEmail(String email) {this.email = email;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setEndereco(Endereco endereco) {this.endereco = endereco;}
    public void setAtivo(Boolean ativo) {this.ativo = ativo;}

    //Constructors -------------------------------
    public Paciente(Long id, String nome, String email, String telefone, String cpf, Endereco endereco, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ativo = ativo;
    }

    public Paciente(PacienteDTO dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = dados.endereco();
    }

    public Paciente(){}

    //Equals and Hash Code for Id ------------------------------
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //Update infos --------------------------------------------
    public void UpdateInfos(@Valid PacienteUpdateDTO dados) {
        if (dados.nome()!=null){this.nome= dados.nome();}
        if (dados.telefone()!=null){this.telefone= dados.telefone();}
        if (dados.endereco()!=null){this.endereco.UpdateInfos(dados.endereco());}
    }

    //Disable --------------------------------------------

    public void Disable (){
        this.ativo = false;
    }
}
