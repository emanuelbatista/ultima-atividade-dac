package br.edu.ifpb.dac.cartao.credito;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty (propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty (propertyName = "destination", propertyValue = "queue/pedido-queue")
})
public class PedidosQueue{

}
