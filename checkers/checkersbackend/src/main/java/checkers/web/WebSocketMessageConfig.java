package checkers.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketMessageConfig implements WebSocketMessageBrokerConfigurer {
    @Override
<<<<<<< HEAD
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/chat-example").setAllowedOrigins("*").withSockJS();
=======
    public void registerStompEndpoints(final StompEndpointRegistry registry){
        registry.addEndpoint("/chat-example").setAllowedOrigins("*");
>>>>>>> main
    }
    
    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}
