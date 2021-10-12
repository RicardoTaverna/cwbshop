package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.State;
import br.pucpr.cwbshop.repository.StateRepository;
import br.pucpr.cwbshop.service.StateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateResource {

    private final StateRepository stateRepository;
    private final StateService stateService;

    public StateResource(StateRepository stateRepository, StateService stateService) {
        this.stateRepository = stateRepository;
        this.stateService = stateService;
    }

    @GetMapping("/{id}")
    public State get_attribute_by_id(@PathVariable("id") int id){
        return stateRepository.getById(id);
    }

    @GetMapping()
    public List<State> get_all(){
        return stateRepository.findAll();
    }

    @PostMapping()
    public State add(@RequestBody State state){
        return stateService.save(state);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        stateRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
