package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.Address;
import br.pucpr.cwbshop.repository.AddressRepository;
import br.pucpr.cwbshop.service.AddressService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Address resource.
 */
@RestController
@RequestMapping("/address")
@Api(value = "/address", tags = "Address", description = "Product Address")
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
    @ApiOperation(value = "Retorna Address pelo ID")
    public Address get_attribute_by_id(@PathVariable("id") int id){
        return addressRepository.getById(id);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping()
    @ApiOperation(value = "Retorna todos Address")
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
    @ApiOperation(value = "Cria Address")
    public Address add(@RequestBody Address address){
        return addressService.save(address);
    }


    /**
     * Update address.
     *
     * @param new_address the new address
     * @param id          the id
     * @return the address
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza Address pelo ID")
    public Address update(@RequestBody Address new_address, @PathVariable("id") int id){
        return addressRepository.findById(id).map(address -> {
            address.setId(new_address.getId());
            address.setState(new_address.getState());
            address.setCountry(new_address.getCountry());
            address.setCity(new_address.getCity());
            address.setProduct(new_address.getProduct());
            return addressService.save(address);
        }).orElseGet(() -> {
            new_address.setAddressId(id);
            return addressService.save(new_address);
        });
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta Address pelo ID")
    public ResponseEntity delete(@PathVariable("id") int id){
        addressRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
