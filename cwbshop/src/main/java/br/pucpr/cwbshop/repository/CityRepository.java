package br.pucpr.cwbshop.repository;

import br.pucpr.cwbshop.domain.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
