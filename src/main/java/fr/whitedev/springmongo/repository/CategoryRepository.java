package fr.whitedev.springmongo.repository;

import fr.whitedev.springmongo.domaine.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {
}
