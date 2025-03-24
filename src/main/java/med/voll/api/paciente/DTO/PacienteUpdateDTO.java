package med.voll.api.paciente.DTO;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.EnderecoDTO;

public record PacienteUpdateDTO (
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO endereco
) {
}
