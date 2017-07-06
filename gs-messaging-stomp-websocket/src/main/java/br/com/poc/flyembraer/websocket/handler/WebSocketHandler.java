package br.com.poc.flyembraer.websocket.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * A classe {@link WebSocketHandler} tem por objetivo enviar um texto
 * para clientOutboundChannel definido na {@code WebSocketConfig}. 
 *
 * @author Roberto Perillo
 * @author Joao Batista
 * @version 2.0 27/06/2017
 */
@Component
public class WebSocketHandler implements MessageHandler {

	private final SimpMessagingTemplate template;
	
	@Autowired
	public WebSocketHandler(final SimpMessagingTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public void handleMessage(final Message<?> message) {
		template.convertAndSend("/topic/greetings", message.getPayload());
	}
}