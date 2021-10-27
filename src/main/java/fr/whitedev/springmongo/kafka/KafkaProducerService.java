package fr.whitedev.springmongo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "messenger";
    @Autowired
    KafkaTemplate<String, String>  kafkaTemplate;

    public String sendMessage(String message){

        final boolean[] isSend = {false};
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(TOPIC,"key"+message.length(),message);

        result.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                isSend[0] = false;
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                isSend[0] = true;
            }
        });
        if(isSend[0]){
            return "SUCCES";
        }else
            return "FAILED";
    }
}
