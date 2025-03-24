package med.voll.api.medico.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DTO.MedicoUpdateDTO;
import med.voll.api.medico.entity.Medico;
import med.voll.api.medico.DTO.MedicoDTO;
import med.voll.api.medico.DTO.MedicoListDTO;
import med.voll.api.medico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar (@RequestBody @Valid MedicoDTO dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<MedicoListDTO> listar (@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(MedicoListDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar (@RequestBody @Valid MedicoUpdateDTO dados){
        var medico = repository.getReferenceById(dados.id());
        medico.UpdateInfos(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar (@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.Disable();
    }
}
