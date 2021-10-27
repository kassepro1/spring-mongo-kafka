package fr.whitedev.springmongo.Controller;


import fr.whitedev.springmongo.kafka.KafkaProducerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    @GetMapping("/kafka/publish/{message}")
    public String onSendMessage(@PathVariable String message){
        return kafkaProducerService.sendMessage(message);
    }
}
