package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.Country;
import br.pucpr.cwbshop.repository.CountryRepository;
import br.pucpr.cwbshop.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Country resource.
 */
@RestController
@RequestMapping("/country")
public class CountryResource {
    private final CountryRepository countryRepository;
    private final CountryService countryService;

    /**
     * Instantiates a new Country resource.
     *
     * @param countryRepository the country repository
     * @param countryService    the country service
     */
    public CountryResource(CountryRepository countryRepository, CountryService countryService) {
        this.countryRepository = countryRepository;
        this.countryService = countryService;
    }

    /**
     * Gets attribute by id.
     *
     * @param id the id
     * @return the attribute by id
     */
    @GetMapping("/{id}")
    public Country get_attribute_by_id(@PathVariable("id") int id){
        return countryRepository.getById(id);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping()
    public List<Country> get_all(){
        return countryRepository.findAll();
    }

    /**
     * Add country.
     *
     * @param country the country
     * @return the country
     */
    @PostMapping()
    public Country add(@RequestBody Country country){
        return countryService.save(country);
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        countryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
