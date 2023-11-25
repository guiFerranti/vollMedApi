package med.voll.api.medico;

import med.voll.api.medico.Especialidade;

public record DadosListagemMedicos(Long id,String nome, String email, String crm, Especialidade especiladade) {
    public DadosListagemMedicos(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}