package kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConcumers {
//    @KafkaListener(topics = "cource")
//    public void listener(ConsumerRecord<String,String> record)
//    {
//
//    }
    @KafkaListener(topics = "cource")
    public void listener(String msg)
    {
    System.out.println("Сообщение"+msg);
    }
}
