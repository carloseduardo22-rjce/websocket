package WebSocketProject.myChatHandler.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import WebSocketProject.myChatHandler.MyHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig {

	public void registerWebSocketHandler(WebSocketHandlerRegistry registry) {
		registry.addHandler(myHandler(), "/myHandler")
		.addInterceptors(new HttpSessionHandshakeInterceptor());
	}
	
	public WebSocketHandler myHandler() {
		return new MyHandler();
	}
	
	public ServletServerContainerFactoryBean createWebSocketContainer() {
		ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
		container.setMaxTextMessageBufferSize(8000);
		container.setMaxBinaryMessageBufferSize(8000);
		return container;
	}
	
}
