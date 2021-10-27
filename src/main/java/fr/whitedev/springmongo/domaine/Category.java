package fr.whitedev.springmongo.domaine;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Document
public class Category {

    @Id
    private String id;

    private String name;

    @DBRef
    private Set<Product> products = new HashSet<>();
}
