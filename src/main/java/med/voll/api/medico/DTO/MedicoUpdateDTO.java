package med.voll.api.medico.DTO;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.EnderecoDTO;

public record MedicoUpdateDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO endereco
) {
}
