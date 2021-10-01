package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.Seller;
import br.pucpr.cwbshop.repository.SellerRepository;
import br.pucpr.cwbshop.service.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerResource {

    private final SellerRepository sellerRepository;
    private final SellerService sellerService;

    public SellerResource(SellerRepository sellerRepository, SellerService sellerService) {
        this.sellerRepository = sellerRepository;
        this.sellerService = sellerService;
    }

    @GetMapping("/{id}")
    public Seller get_attribute_by_id(@PathVariable("id") int id){
        return sellerRepository.getById(id);
    }

    @GetMapping()
    public List<Seller> get_all(){
        return sellerRepository.findAll();
    }

    @PostMapping()
    public Seller add(@RequestBody Seller seller){
        return sellerService.save(seller);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        sellerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
