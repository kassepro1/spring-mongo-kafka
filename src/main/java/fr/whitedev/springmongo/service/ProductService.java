package fr.whitedev.springmongo.service;


import fr.whitedev.springmongo.domaine.Category;
import fr.whitedev.springmongo.domaine.Product;
import fr.whitedev.springmongo.domaine.dto.ProductDto;
import fr.whitedev.springmongo.repository.CategoryRepository;
import fr.whitedev.springmongo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public Product createProduct(ProductDto productDto, String categoryId){
        Category category = categoryRepository.findById(categoryId).orElse(new Category());
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        log.info("product "+product.getName());
        Product p = productRepository.save(product);
        log.info("product after "+p.getName());
        category.getProducts().add(p);
        categoryRepository.save(category);
        return p;
    }

    public boolean deleteProduct(String productId,String categoryId){
        boolean isDel = false;
        try{
            Category category = categoryRepository.findById(categoryId).orElse(new Category());
            Product product = productRepository.findById(productId).orElse(new Product());
            productRepository.delete(product);
            category.getProducts().remove(product);
            categoryRepository.save(category);
            isDel = true;
        }catch (Exception ex){
            log.info("exception "+ex.getMessage());
        }
      return isDel;
    }

    public List<Product> findProductBeetween(double priceLt, double pricegT){
       return productRepository.findProductBeetween(priceLt,pricegT);
    }
}
