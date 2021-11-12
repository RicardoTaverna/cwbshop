package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.Address;
import br.pucpr.cwbshop.repository.AddressRepository;
import br.pucpr.cwbshop.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressResource {

    private final AddressRepository addressRepository;
    private final AddressService addressService;

    public AddressResource(AddressRepository addressRepository, AddressService addressService) {
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public Address get_attribute_by_id(@PathVariable("id") int id){
        return addressRepository.getById(id);
    }

    @GetMapping()
    public List<Address> get_all(){
        return addressRepository.findAll();
    }

    @PostMapping()
    public Address add(@RequestBody Address address){
        return addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        addressRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
