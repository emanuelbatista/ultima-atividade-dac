package br.edu.ifpb.dac.pagamento;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *@ActivationConfigProperty(propertyName = "destination",
                    propertyValue = "java:global/jms/demoConnectionFactory")
                    * 
                    * ,
            @ActivationConfigProperty(propertyName = "messageSelector",
                    propertyValue = "cartao = 'cred'")
 * @author Emanuel
 */
@MessageDriven(
        mappedName = "jms/myTopic")
public class ConsumidorTopicAsync implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;
            System.out.println("Mensagem Recebida do Topic: " + tm.getText());
        } catch (JMSException ex) {
            Logger.getLogger(ConsumidorTopicAsync.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
