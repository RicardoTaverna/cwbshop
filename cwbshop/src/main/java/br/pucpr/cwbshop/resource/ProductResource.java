package br.pucpr.cwbshop.resource;

import br.pucpr.cwbshop.domain.entity.Attribute;
import br.pucpr.cwbshop.domain.entity.Product;
import br.pucpr.cwbshop.repository.ProductRepository;
import br.pucpr.cwbshop.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Product resource.
 */
@RestController
@RequestMapping("/api/product")
@Api(value = "/api/product", tags = "Product", description = "Product ")
public class ProductResource {

    private final ProductRepository productRepository;
    private final ProductService productService;

    /**
     * Instantiates a new Product resource.
     *
     * @param productRepository the product repository
     * @param productService    the product service
     */
    public ProductResource(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     */

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna Produto pelo ID")
    public Product get_product_by_id(@PathVariable("id") int id){
        return productRepository.getById(id);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping()
    @ApiOperation(value = "Retorna todos Produtos")
    public List<Product> get_all(){
        return productRepository.findAll();
    }

    /**
     * Add product.
     *
     * @param product the product
     * @return the product
     */
    @PostMapping()
    @ApiOperation(value = "Cria um Produto")
    public Product add(@RequestBody Product product){
        return productService.save(product);
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta Produto pelo ID")
    public ResponseEntity delete(@PathVariable("id") int id){
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Update product.
     *
     * @param new_product the new product
     * @param id          the id
     * @return the product
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza Produto pelo ID")
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
