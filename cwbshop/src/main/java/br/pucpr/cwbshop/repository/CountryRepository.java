package br.pucpr.cwbshop.repository;

import br.pucpr.cwbshop.domain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Country repository.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
