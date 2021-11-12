package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.City;
import br.pucpr.cwbshop.repository.CityRepository;
import br.pucpr.cwbshop.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityResource {

    private final CityRepository cityRepository;
    private final CityService cityService;

    public CityResource(CityRepository cityRepository, CityService cityService) {
        this.cityRepository = cityRepository;
        this.cityService = cityService;
    }

    @GetMapping("/{id}")
    public City get_attribute_by_id(@PathVariable("id") int id){
        return cityRepository.getById(id);
    }

    @GetMapping()
    public List<City> get_all(){
        return cityRepository.findAll();
    }

    @PostMapping()
    public City add(@RequestBody City city){
        return cityService.save(city);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        cityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
