package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.Attribute;
import br.pucpr.cwbshop.repository.AttributeRepository;
import br.pucpr.cwbshop.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attribute")
public class AttributeResource {

    private final AttributeRepository attributeRepository;
    private final AttributeService attributeService;

    public AttributeResource(AttributeRepository attributeRepository, AttributeService attributeService) {
        this.attributeRepository = attributeRepository;
        this.attributeService = attributeService;
    }

    @GetMapping("/{id}")
    public Attribute get_attribute_by_id(@PathVariable("id") int id){
        return attributeRepository.getById(id);
    }

    @GetMapping()
    public List<Attribute> get_all(){
        return attributeRepository.findAll();
    }

    @PostMapping()
    public Attribute add(@RequestBody Attribute attribute){
        return attributeService.save(attribute);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        attributeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public Attribute update(@RequestBody Attribute new_attribute, @PathVariable("id") int id){
        return attributeRepository.findById(id).map(attribute -> {
            attribute.setAttribute_id(new_attribute.getAttribute_id());
            attribute.setValue_name(new_attribute.getValue_name());
            return attributeService.save(attribute);
        }).orElseGet(() -> {
            new_attribute.setId(id);
            return attributeService.save(new_attribute);
        });
    }
}
