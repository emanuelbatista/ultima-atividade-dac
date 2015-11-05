/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.ejb.manage.bean.produtor.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;
import javax.jms.Message;
import javax.jms.Topic;

/**
 *
 * @author Emanuel
 */
@Stateless
@LocalBean
public class Produtor {

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "jms/myTopic")
    private Topic canalDeDestino;

    public void enviarMensagem(String body) {
        try {
            Message mensagem = context.createTextMessage(body);
//            mensagem.setStringProperty("cartao", "cred"); //seletor
            context.createProducer().send(canalDeDestino, mensagem);
        } catch (JMSRuntimeException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } 
    }
}