package med.voll.api.paciente.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.DTO.PacienteUpdateDTO;
import med.voll.api.paciente.entity.Paciente;
import med.voll.api.paciente.DTO.PacienteDTO;
import med.voll.api.paciente.DTO.PacienteListDTO;
import med.voll.api.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar (@RequestBody @Valid PacienteDTO dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<PacienteListDTO> listar (@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(PacienteListDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar (@RequestBody @Valid PacienteUpdateDTO dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.UpdateInfos(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir (@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.Disable();
    }

}
