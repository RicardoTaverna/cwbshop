package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.City;
import br.pucpr.cwbshop.repository.CityRepository;
import br.pucpr.cwbshop.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type City resource.
 */
@RestController
@RequestMapping("/city")
public class CityResource {

    private final CityRepository cityRepository;
    private final CityService cityService;

    /**
     * Instantiates a new City resource.
     *
     * @param cityRepository the city repository
     * @param cityService    the city service
     */
    public CityResource(CityRepository cityRepository, CityService cityService) {
        this.cityRepository = cityRepository;
        this.cityService = cityService;
    }

    /**
     * Gets attribute by id.
     *
     * @param id the id
     * @return the attribute by id
     */
    @GetMapping("/{id}")
    public City get_attribute_by_id(@PathVariable("id") int id){
        return cityRepository.getById(id);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping()
    public List<City> get_all(){
        return cityRepository.findAll();
    }

    /**
     * Add city.
     *
     * @param city the city
     * @return the city
     */
    @PostMapping()
    public City add(@RequestBody City city){
        return cityService.save(city);
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        cityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
