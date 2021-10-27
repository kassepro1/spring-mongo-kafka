package fr.whitedev.springmongo.repository;

import fr.whitedev.springmongo.domaine.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {

    @Query("{ 'price' : { $gt: ?0, $lt: ?1 } }")
    List<Product> findProductBeetween(double priceLt,double pricegT);
}
