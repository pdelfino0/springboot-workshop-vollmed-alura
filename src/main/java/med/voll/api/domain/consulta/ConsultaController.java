package med.voll.api.domain.consulta;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsulta agenda;

    @Transactional
    @PostMapping
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        agenda.agendarConsulta(dados);
        return ResponseEntity.ok().body(new DadosDetalhamentoConsulta(null, null, null, null));
    }

    pr
}
