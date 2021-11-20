package br.pucpr.cwbshop.service;

import br.pucpr.cwbshop.domain.entity.Country;
import br.pucpr.cwbshop.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Country service.
 */
@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    /**
     * Save country.
     *
     * @param country the country
     * @return the country
     */
    public Country save(Country country){
        return countryRepository.save(country);
    }
}
