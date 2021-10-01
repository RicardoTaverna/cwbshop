package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.Country;
import br.pucpr.cwbshop.repository.CountryRepository;
import br.pucpr.cwbshop.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryResource {
    private final CountryRepository countryRepository;
    private final CountryService countryService;

    public CountryResource(CountryRepository countryRepository, CountryService countryService) {
        this.countryRepository = countryRepository;
        this.countryService = countryService;
    }

    @GetMapping("/{id}")
    public Country get_attribute_by_id(@PathVariable("id") int id){
        return countryRepository.getById(id);
    }

    @GetMapping()
    public List<Country> get_all(){
        return countryRepository.findAll();
    }

    @PostMapping()
    public Country add(@RequestBody Country country){
        return countryService.save(country);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        countryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
