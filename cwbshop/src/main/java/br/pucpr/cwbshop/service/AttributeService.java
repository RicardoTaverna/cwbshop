package br.pucpr.cwbshop.service;

import br.pucpr.cwbshop.domain.entity.Attribute;
import br.pucpr.cwbshop.repository.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeService {
    @Autowired
    private AttributeRepository attributeRepository;

    public Attribute save(Attribute attribute){
        return attributeRepository.save(attribute);
    }
}
