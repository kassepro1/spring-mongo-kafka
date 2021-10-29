package fr.whitedev.springmongo.kafka;

import fr.whitedev.springmongo.domaine.Category;
import fr.whitedev.springmongo.domaine.Product;
import fr.whitedev.springmongo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @Autowired
    private ProductRepository productRepository;

    @KafkaListener(topics = "catalog",containerFactory = "kafkaListenerContainerFactory")
    public Product subcribeToMessage(ConsumerRecord<String, Product> cr){
        Product product = cr.value();
        product = productRepository.save(product);
        log.info(" Name ----: "+product.getName());
        log.info(" Price ----: "+product.getPrice());
        log.info(" Id ----: "+product.getPrice());
        return  product;
    }

    @KafkaListener(topics = "catalog-cat",containerFactory = "categoryConcurrentKafkaListenerContainerFactory")
    public void subcribeToCategoryMessage(ConsumerRecord<String, Category> cr){
        Category category = cr.value();
        log.info(" Name ----: "+category.getName());
    }
}
