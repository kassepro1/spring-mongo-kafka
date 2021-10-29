package fr.whitedev.springmongo.kafka;

import fr.whitedev.springmongo.domaine.Category;
import fr.whitedev.springmongo.domaine.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@Slf4j
public class KafkaProducerService {
    private static final String TOPIC = "catalog";
    @Autowired
    KafkaTemplate<String, Product>  kafkaTemplate;

    @Autowired
    KafkaTemplate<String, Category>  categoryKafkaTemplate;

    public String sendMessage(Product product){
            boolean isSend = false;
        try{
            kafkaTemplate.send(TOPIC,"key"+product.getName().length(),product);
            isSend = true;
        }catch (Exception ex){
            isSend = false ;
            log.info("error "+ex.getStackTrace());
        }
        //ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(TOPIC,"key"+message.length(),message);

        /*result.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                isSend.set(false);
                log.info("Message is not send ....");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                isSend.set(true);
                log.info("Message is  send ....");
            }
        });*/
        log.info(" INfo "+isSend);
        if (!isSend) {
            return "FAILED";
        } else {
            return "SUCCESS";
        }
    }

    public String sendCategoryMessage(Category category){
        boolean isSend = false;
        try{
            categoryKafkaTemplate.send("catalog-cat","key"+category.getName().length(),category);
            isSend = true;
        }catch (Exception ex){
            isSend = false ;
            log.info("error "+ex.getStackTrace());
        }
        //ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(TOPIC,"key"+message.length(),message);

        /*result.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                isSend.set(false);
                log.info("Message is not send ....");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                isSend.set(true);
                log.info("Message is  send ....");
            }
        });*/
        log.info(" INfo "+isSend);
        if (!isSend) {
            return "FAILED";
        } else {
            return "SUCCESS";
        }
    }
}
