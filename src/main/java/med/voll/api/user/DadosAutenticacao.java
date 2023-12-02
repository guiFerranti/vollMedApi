package med.voll.api.user;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        @NotBlank
        String login,
        @NotBlank
        String senha) {}
