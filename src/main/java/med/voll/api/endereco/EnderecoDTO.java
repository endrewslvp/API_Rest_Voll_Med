package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(

        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{5}\\-\\d{2}")
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        String complemento,
        String numero
) {
}
