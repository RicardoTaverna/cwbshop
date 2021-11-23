package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.City;
import br.pucpr.cwbshop.repository.CityRepository;
import br.pucpr.cwbshop.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type City resource.
 */
@RestController
@RequestMapping("/city")
@Api(value = "/city", tags = "City", description = "Product City")
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
    @ApiOperation(value = "Retorna City pelo ID")
    public City get_attribute_by_id(@PathVariable("id") int id){
        return cityRepository.getById(id);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping()
    @ApiOperation(value = "Retorna todas City")
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
    @ApiOperation(value = "Cria City")
    public City add(@RequestBody City city){
        return cityService.save(city);
    }

    /**
     * Update city.
     *
     * @param new_city the new city
     * @param id       the id
     * @return the city
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza City pelo ID")
    public City update(@RequestBody City new_city, @PathVariable("id") int id){
        return cityRepository.findById(id).map(city -> {
            city.setName(new_city.getName());
            city.setId(new_city.getId());
            city.setAddress(new_city.getAddress());
            return cityService.save(city);
        }).orElseGet(() -> {
            new_city.setCityId(id);
            return cityService.save(new_city);
        });
    }


    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta City pelo ID")
    public ResponseEntity delete(@PathVariable("id") int id){
        cityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
