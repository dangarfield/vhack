package dan.vhack;

import java.util.Map.Entry;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class UserWebSocketHandler {

	@OnWebSocketConnect
	public void onConnect(Session session) throws Exception {
		session.getRemote().sendString("Prompt for registration");
		System.out.println("onConnect: " + session);
	}

	@OnWebSocketClose
	public void onClose(Session session, int statusCode, String reason) {
		System.out.println("onClose: " + session);
		String username = getWSSessionKeyFromValue(session);
		if(username != null) {
			Crawl.RUNNING_USER_WS_SESSIONS.remove(username);
			System.out.println("Removing ws session: " + username);
		}
	}

	private String getWSSessionKeyFromValue(Session session) {
		for (Entry<String, Session> entry : Crawl.RUNNING_USER_WS_SESSIONS.entrySet()) {
			if(entry.getValue().equals(session)) {
				return entry.getKey();
			}
	    }
		return null;
	}

	@OnWebSocketMessage
	public void onMessage(Session session, String msg) {
		if(msg.startsWith("register")) {
			String username = msg.substring(msg.indexOf("|")+1);
			System.out.println("Registration message received: " + username);
			Crawl.RUNNING_USER_WS_SESSIONS.put(username, session);
		} else {
			System.out.println("Unknown message received: " + msg);
		}
	}

}