package kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.appline.logic.Pet;
@Service
public class KafkaProducer {
    //
    private final KafkaTemplate<String,String> template;
    private final KafkaTemplate<String,Pet> templatePet;
    public KafkaProducer(KafkaTemplate<String, String> template, KafkaTemplate<String, Pet> templatePet1) {
        this.template = template;
        this.templatePet = templatePet1;
    }
    public void sendMessage(String msg)
    {
        template.send("cource",msg);
    }
    public void sendMessagePet(Pet msg)
    {
        template.send("cource",msg);
    }
}
