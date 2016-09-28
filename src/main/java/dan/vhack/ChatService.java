package dan.vhack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class ChatService {

	public static void main(String[] args) throws IOException {
		UserData userData = new UserData();
		Auth auth = new Auth("dangarfield", "");
		userData.setAuth(auth);
		userData.setHash("caa9e197c362028a09bf72c398b9f0da");
		userData.setId(322262);
		ChatService cs = new ChatService(userData);
		cs.register(userData);
	}

	private BufferedWriter bufferedWriter;
	private BufferedReader bufferedReader;
	private boolean running = true;
	private String s = "#vHackXT";

	public ChatService(UserData userData) {
		register(userData);
	}

	public void register(UserData userData) {
		Socket echoSocket = null;
		try {
			System.out.println("connect");
			echoSocket = new Socket("chat.vhackxt.com", 7531);
			// PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),
			// true);

			System.out.println("create in");
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(echoSocket.getOutputStream()));
			bufferedReader = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

			String hash = userData.getHash(); // "caa9e197c362028a09bf72c398b9f0da";
			String name = userData.getAuth().getUsername(); // "dangarfield";
			String id = String.valueOf(userData.getId()); // "322262";

			String p = name.replace(" ", "").replace(".", "");
			String str2 = "v[" + p + "_";
			str2 = "v[Combat_tiger";
			bufferedWriter.write("PASS " + hash + "\r\nNICK " + str2 + "\r\n");
			bufferedWriter.write("USER " + id + " 0 * : vHack XT@Android\r\n");
			bufferedWriter.flush();

			// BufferedReader stdIn = new BufferedReader(new
			// InputStreamReader(System.in));
			System.out.println("start loop");

//			int count = 0;

			while (running) {
				/*count++;
				System.out.println(count);
				if (count == 85) {
					String msg = "a";
					String msgWrapper = "PRIVMSG " + s + " :" + msg + "\r\n";
					bufferedWriter.write(msgWrapper);
					bufferedWriter.flush();
				}*/
				String readLine = bufferedReader.readLine();
				if (readLine != null) {
//					System.out.println(readLine);
					//Crawl.logToUser(userData.getAuth().getUsername(), "chat|"+readLine);
					if (readLine.toLowerCase().startsWith("ping ")) {
						String str3 = "PONG " + readLine.substring(5) + "\r\n";
						System.out.println(str3);
						str3.getBytes();
						bufferedWriter.write(str3);
						bufferedWriter.flush();
					}
					if (readLine.contains(":(channel is full) transfering you to #")) {
						String something = readLine
								.substring(readLine.indexOf(":(channel is full) transfering you to", 1))
								.replace(":(channel is full) transfering you to ", "").replace("\r", "")
								.replace("\n", "").replace(" ", "");
						System.out.println(something);
					}
					if (readLine.contains(" 433 *")) {
						bufferedWriter.write("NICK " + str2 + "_" + "\r\n");
						bufferedWriter.flush();
					}
					if (readLine.contains("376")) {
						bufferedWriter.write("JOIN " + s + "\r\n");
						bufferedWriter.flush();
						bufferedWriter.flush();
					}
					if (readLine.contains("PRIVMSG ")) {
						// this.a.F = a(readLine);
						// this.a.H = b(readLine);
						// this.a.G = a(readLine, this.a.s);
						// this.a.G = this.a.G.replace("<", "");
						// this.a.G = this.a.G.replace(">", "");
						// this.a.G = this.a.G.replace("'", "");
						// this.a.runOnUiThread(new ds(this));
						String user = readLine.substring(3, readLine.indexOf("!"));
						String msg = readLine.substring(readLine.indexOf("#vHackXT :") + 10);
						logMessage( userData.getAuth().getUsername(), user, msg);
//						System.out.println(user + " - " + msg);
						
//						:v[Th3_Hunt3t_!422519@8960F195.2F872F7A.5073761D.IP PRIVMSG #vHackXT :Hast du nen Cluster oder so?:D
//								Exception in thread "main" close
//								java.lang.StringIndexOutOfBoundsException: String index out of range: -4
					}
				} else {
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("close");
			try {
				echoSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void logMessage(String username, String chatUser, String msg) {
		String stats = Crawl.getUserScanString(chatUser);
		Crawl.logToUser(username, "chat|||"+chatUser+"|||"+msg+"|||"+stats);
	}

	public void setRunning(boolean b) {
		running = b;
	}

	public void write(String msg) {

		try {
			String msgWrapper = "PRIVMSG " + s + " :" + msg + "\r\n";
			bufferedWriter.write(msgWrapper);
			bufferedWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
