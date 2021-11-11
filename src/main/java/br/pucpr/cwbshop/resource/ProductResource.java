package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.Attribute;
import br.pucpr.cwbshop.domain.entity.Product;
import br.pucpr.cwbshop.repository.ProductRepository;
import br.pucpr.cwbshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductResource {

    private final ProductRepository productRepository;
    private final ProductService productService;

    public ProductResource(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product get_product_by_id(@PathVariable("id") int id){
        return productRepository.getById(id);
    }

    @GetMapping()
    public List<Product> get_all(){
        return productRepository.findAll();
    }

    @PostMapping()
    public Product add(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody Product new_product, @PathVariable("id") int id){
        return productRepository.findById(id).map(product -> {
            product.setSite_id(new_product.getSite_id());
            product.setTitle(new_product.getTitle());
            product.setSubtitle(new_product.getSubtitle());
            product.setBase_price(new_product.getBase_price());
            product.setOriginal_price(new_product.getOriginal_price());
            product.setCurrency_id(new_product.getCurrency_id());
            product.setInitial_quantity(new_product.getInitial_quantity());
            product.setAvailable_quantity(new_product.getAvailable_quantity());
            product.setCondition(new_product.getCondition());
            product.setPermalink(new_product.getPermalink());
            return productService.save(product);
        }).orElseGet(() -> {
            new_product.setProduct_id(id);
            return productService.save(new_product);
        });
    }

}
