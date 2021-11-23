package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.State;
import br.pucpr.cwbshop.repository.StateRepository;
import br.pucpr.cwbshop.service.StateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type State resource.
 */
@RestController
@RequestMapping("/state")
@Api(value = "/state", tags = "State", description = "Product State")
public class StateResource {

    private final StateRepository stateRepository;
    private final StateService stateService;

    /**
     * Instantiates a new State resource.
     *
     * @param stateRepository the state repository
     * @param stateService    the state service
     */
    public StateResource(StateRepository stateRepository, StateService stateService) {
        this.stateRepository = stateRepository;
        this.stateService = stateService;
    }

    /**
     * Gets attribute by id.
     *
     * @param id the id
     * @return the attribute by id
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna State pelo ID")
    public State get_attribute_by_id(@PathVariable("id") int id){
        return stateRepository.getById(id);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping()
    @ApiOperation(value = "Retorna todos State")
    public List<State> get_all(){
        return stateRepository.findAll();
    }

    /**
     * Add state.
     *
     * @param state the state
     * @return the state
     */
    @PostMapping()
    @ApiOperation(value = "Cria um State")
    public State add(@RequestBody State state){
        return stateService.save(state);
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um State pelo ID")
    public ResponseEntity delete(@PathVariable("id") int id){
        stateRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
