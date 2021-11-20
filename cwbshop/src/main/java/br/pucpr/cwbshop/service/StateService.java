package br.pucpr.cwbshop.service;

import br.pucpr.cwbshop.domain.entity.State;
import br.pucpr.cwbshop.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type State service.
 */
@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    /**
     * Save state.
     *
     * @param state the state
     * @return the state
     */
    public State save(State state){
        return stateRepository.save(state);
    }

}
