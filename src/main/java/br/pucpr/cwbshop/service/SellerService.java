package br.pucpr.cwbshop.service;

import br.pucpr.cwbshop.domain.entity.Seller;
import br.pucpr.cwbshop.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public Seller save(Seller seller){
        return sellerRepository.save(seller);
    }
}

