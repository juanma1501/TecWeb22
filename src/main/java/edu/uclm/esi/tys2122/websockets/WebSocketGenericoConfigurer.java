package edu.uclm.esi.tys2122.websockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketGenericoConfigurer implements WebSocketConfigurer {
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.
			addHandler(new WebSocketGenerico(), "/wsGenerico").
			setAllowedOrigins("*").
			addInterceptors(new HttpSessionHandshakeInterceptor());
	}
}
