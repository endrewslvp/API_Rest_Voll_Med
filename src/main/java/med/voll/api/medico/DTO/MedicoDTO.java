package med.voll.api.medico.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.endereco.EnderecoDTO;
import med.voll.api.medico.entity.Especialidade;

public record MedicoDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{2} \\d{5}-\\d{4}")
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        EnderecoDTO endereco
) {
}
