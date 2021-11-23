package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.Address;
import br.pucpr.cwbshop.repository.AddressRepository;
import br.pucpr.cwbshop.service.AddressService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Address resource.
 */
@RestController
@RequestMapping("/address")
public class AddressResource {

    private final AddressRepository addressRepository;
    private final AddressService addressService;

    /**
     * Instantiates a new Address resource.
     *
     * @param addressRepository the address repository
     * @param addressService    the address service
     */
    public AddressResource(AddressRepository addressRepository, AddressService addressService) {
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    /**
     * Gets attribute by id.
     *
     * @param id the id
     * @return the attribute by id
     */
    @GetMapping("/{id}")
    public Address get_attribute_by_id(@PathVariable("id") int id){
        return addressRepository.getById(id);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping()
    public List<Address> get_all(){
        return addressRepository.findAll();
    }

    /**
     * Add address.
     *
     * @param address the address
     * @return the address
     */
    @PostMapping()
    public Address add(@RequestBody Address address){
        return addressService.save(address);
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        addressRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
