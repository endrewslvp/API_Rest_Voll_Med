package med.voll.api.paciente.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.Endereco;
import org.hibernate.validator.constraints.br.CPF;

public record PacienteDTO(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{2} \\d{5}-\\d{4}")
        String telefone,

        @NotBlank
        @CPF
        String cpf,

        @NotNull
        @Valid
        Endereco endereco
) {
}
