package com.smhrd.bridge.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 클라이언트로부터 메시지를 받았을 때의 로직을 구현합니다.
		String payload = message.getPayload();
		// payload를 파싱하고 필요한 처리를 수행합니다.
	}
}
