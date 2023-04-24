package med.voll.api.validacoes.consulta.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.validacoes.consulta.abstracao.ValidadorAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component

public class ValidadorHorárioFuncionamentoClinica implements ValidadorAgendamentoConsulta {
    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        var dataConsulta = dadosAgendamentoConsulta.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
