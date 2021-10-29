package fr.whitedev.springmongo.Controller;


import fr.whitedev.springmongo.domaine.Category;
import fr.whitedev.springmongo.domaine.Product;
import fr.whitedev.springmongo.kafka.KafkaConsumerService;
import fr.whitedev.springmongo.kafka.KafkaProducerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    private final KafkaConsumerService kafkaConsumerService;

    @PostMapping("/kafka/publish")
    public String onSendMessage(@RequestBody Product product){
        return kafkaProducerService.sendMessage(product);
    }

    @PostMapping("/kafka/categories/publish")
    public String onSendMessage(@RequestBody Category category){
        return kafkaProducerService.sendCategoryMessage(category);
    }

}
