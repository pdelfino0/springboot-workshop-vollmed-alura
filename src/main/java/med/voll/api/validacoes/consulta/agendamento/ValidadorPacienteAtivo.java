package med.voll.api.validacoes.consulta.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.validacoes.consulta.abstracao.ValidadorAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class ValidadorPacienteAtivo implements ValidadorAgendamentoConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = repository.findByAtivoById(dados.idPaciente());

        if (!pacienteEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada para paciente excluído!");
        }
    }
}
