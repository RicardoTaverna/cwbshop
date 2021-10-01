package br.pucpr.cwbshop.service;

import br.pucpr.cwbshop.domain.entity.Promotion;
import br.pucpr.cwbshop.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;

    public Promotion save(Promotion promotion){
        return promotionRepository.save(promotion);
    }
}
