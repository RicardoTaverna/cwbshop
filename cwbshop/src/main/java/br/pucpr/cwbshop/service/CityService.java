package br.pucpr.cwbshop.service;

import br.pucpr.cwbshop.domain.entity.City;
import br.pucpr.cwbshop.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type City service.
 */
@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    /**
     * Save city.
     *
     * @param city the city
     * @return the city
     */
    public City save(City city){
        return cityRepository.save(city);
    }

}
