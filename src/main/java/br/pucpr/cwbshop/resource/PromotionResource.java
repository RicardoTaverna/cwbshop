package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.Promotion;
import br.pucpr.cwbshop.repository.PromotionRepository;
import br.pucpr.cwbshop.service.PromotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotion")
public class PromotionResource {

    private final PromotionRepository promotionRepository;
    private final PromotionService promotionService;

    public PromotionResource(PromotionRepository promotionRepository, PromotionService promotionService) {
        this.promotionRepository = promotionRepository;
        this.promotionService = promotionService;
    }

    @GetMapping("/{id}")
    public Promotion get_attribute_by_id(@PathVariable("id") int id){
        return promotionRepository.getById(id);
    }

    @GetMapping()
    public List<Promotion> get_all(){
        return promotionRepository.findAll();
    }

    @PostMapping()
    public Promotion add(@RequestBody Promotion promotion){
        return promotionService.save(promotion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        promotionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
