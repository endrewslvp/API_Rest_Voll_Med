package med.voll.api.medico.DTO;

import med.voll.api.medico.entity.Especialidade;
import med.voll.api.medico.entity.Medico;

public record MedicoListDTO(Long Id, String nome, String email, String crm, Especialidade especialidade) {

    public MedicoListDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
