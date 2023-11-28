package med.voll.api.domain.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.Endereco;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        String cpf,
        @NotNull
        Endereco endereco) {

}
