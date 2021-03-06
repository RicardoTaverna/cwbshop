package br.pucpr.cwbshop.repository;

import br.pucpr.cwbshop.domain.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface State repository.
 */
@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
    State findFirstByOrderByStateId();
}
