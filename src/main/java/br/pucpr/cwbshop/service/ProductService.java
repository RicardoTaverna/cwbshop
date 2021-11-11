package br.pucpr.cwbshop.service;

import br.pucpr.cwbshop.domain.entity.Address;
import br.pucpr.cwbshop.domain.entity.Product;
import br.pucpr.cwbshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){
        Address address = product.getSeller_address();
        address.setProduct(product);
        return productRepository.save(product);
    }
}
