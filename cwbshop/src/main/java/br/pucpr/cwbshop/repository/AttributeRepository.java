package br.pucpr.cwbshop.repository;

import br.pucpr.cwbshop.domain.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {

}
