package med.voll.api.paciente.DTO;

import med.voll.api.paciente.entity.Paciente;

public record PacienteListDTO(Long Id, String nome, String email, String cpf) {

    public PacienteListDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
