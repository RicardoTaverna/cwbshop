package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.Attribute;
import br.pucpr.cwbshop.repository.AttributeRepository;
import br.pucpr.cwbshop.service.AttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Attribute resource.
 */
@RestController
@RequestMapping("/attribute")
@Api(value = "/attribute", tags = "Attribute", description = "Attribute Resource")
public class AttributeResource {

    private final AttributeRepository attributeRepository;
    private final AttributeService attributeService;

    /**
     * Instantiates a new Attribute resource.
     *
     * @param attributeRepository the attribute repository
     * @param attributeService    the attribute service
     */
    public AttributeResource(AttributeRepository attributeRepository, AttributeService attributeService) {
        this.attributeRepository = attributeRepository;
        this.attributeService = attributeService;
    }

    /**
     * Gets attribute by id.
     *
     * @param id the id
     * @return the attribute by id
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna Attribute pelo ID")
    public Attribute get_attribute_by_id(@PathVariable("id") int id){
        return attributeRepository.getById(id);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping()
    @ApiOperation(value = "Retorna todos Attribute")
    public List<Attribute> get_all(){
        return attributeRepository.findAll();
    }

    /**
     * Add attribute.
     *
     * @param attribute the attribute
     * @return the attribute
     */
    @PostMapping()
    @ApiOperation(value = "Cria Attribute")
    public Attribute add(@RequestBody Attribute attribute){
        return attributeService.save(attribute);
    }


    /**
     * Update attribute.
     *
     * @param new_attribute the new attribute
     * @param id            the id
     * @return the attribute
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza Attribute pelo ID")
    public Attribute update(@RequestBody Attribute new_attribute, @PathVariable("id") int id){
        return attributeRepository.findById(id).map(attribute -> {
            attribute.setId(new_attribute.getId());
            attribute.setValue_name(new_attribute.getValue_name());
            attribute.setProduct(new_attribute.getProduct());
            return attributeService.save(attribute);
        }).orElseGet(() -> {
            new_attribute.setAttributeId(id);
            return attributeService.save(new_attribute);
        });
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta Attribute pelo ID")
    public ResponseEntity delete(@PathVariable("id") int id){
        attributeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
