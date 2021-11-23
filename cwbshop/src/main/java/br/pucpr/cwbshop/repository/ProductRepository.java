package br.pucpr.cwbshop.repository;

import br.pucpr.cwbshop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Product repository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findFirstByOrderByProductId();
}
