package br.pucpr.cwbshop.service;

import br.pucpr.cwbshop.domain.entity.Address;
import br.pucpr.cwbshop.domain.entity.Attribute;
import br.pucpr.cwbshop.domain.entity.Product;
import br.pucpr.cwbshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){
        List<Attribute> attributes = product.getAttributes();
        System.out.println(attributes);


        Address address = product.getSeller_address();
        address.setProduct(product);
        return productRepository.save(product);
    }
}
