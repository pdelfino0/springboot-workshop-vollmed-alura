package med.voll.api.validacoes.consulta.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.validacoes.consulta.abstracao.ValidadorAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsulta {


    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferençaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();
        if (diferençaEmMinutos < 30) {
            throw new ValidacaoException("Consultas devem ser marcadas com antecedência mínima de 30 minutos");
        }


    }
}
