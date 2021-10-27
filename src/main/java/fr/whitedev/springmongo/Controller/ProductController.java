package fr.whitedev.springmongo.Controller;

import fr.whitedev.springmongo.domaine.Product;
import fr.whitedev.springmongo.domaine.dto.ProductDto;
import fr.whitedev.springmongo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products/{categoryId}")
    Product createProduct(@RequestBody ProductDto productDto, @PathVariable String categoryId){
        return productService.createProduct(productDto,categoryId);
    }

    @DeleteMapping("/products/{productId}/{categoryId}")
    public boolean deleteProduct(@PathVariable String productId,@PathVariable String categoryId){
        return productService.deleteProduct(productId,categoryId);
    }

    @GetMapping("/products")
    public List<Product> findProductBeetween(@RequestParam double priceLt, @RequestParam double pricegT){
        return productService.findProductBeetween(priceLt,pricegT);
    }
}
