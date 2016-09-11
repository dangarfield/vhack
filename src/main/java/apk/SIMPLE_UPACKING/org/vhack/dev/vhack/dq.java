package org.vhack.dev.vhack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/* compiled from: MainActivity */
class dq extends Thread {
    final /* synthetic */ MainActivity f5380a;

    dq(MainActivity mainActivity) {
        this.f5380a = mainActivity;
    }

    public String m9143a(String str) {
        return str.substring(str.indexOf(":") + 1, str.indexOf("!")).replace("v[", "");
    }

    public String m9145b(String str) {
        return str.substring(str.indexOf("@") + 1, str.indexOf("PRIVMSG") - 1);
    }

    public String m9144a(String str, String str2) {
        return str.substring((str.indexOf(str2 + " :") + str2.length()) + 2, str.length());
    }

    public String m9146c(String str) {
        String str2 = "abcdefghijklmnopqrstuvwxyz0123456789[]_{}|";
        String str3 = "";
        for (int i = 0; i < str.length(); i++) {
            String substring = str.substring(i, i + 1);
            if (str2.contains(substring.toLowerCase())) {
                str3 = str3 + substring;
            }
        }
        if (str3.length() < 5) {
            return str3 + "|";
        }
        return str3;
    }

    public void run() {
        String str = "";
        byte[] bArr = new byte[1024];
        try {
            str = "";
            this.f5380a.f5123l = new Socket("chat.vhackxt.com", 7531);
            this.f5380a.runOnUiThread(new dr(this));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.f5380a.f5123l.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f5380a.f5123l.getInputStream()));
            Thread dtVar = new dt(this.f5380a, this.f5380a.f5123l);
            new du(this.f5380a, this.f5380a.f5123l).start();
            dtVar.start();
            this.f5380a.f5130s = "#vHackXT";
            this.f5380a.f5127p.replace(" ", "").replace(".", "");
            String str2 = "v[" + m9146c(this.f5380a.f5127p);
            bufferedWriter.write("PASS " + this.f5380a.f5132u + "\r\nNICK " + str2 + "\r\n");
            bufferedWriter.write("USER " + this.f5380a.f5133v + " 0 * : vHack XT@Android\r\n");
            bufferedWriter.flush();
            this.f5380a.getSharedPreferences("ChatData.xml", 0);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.toLowerCase().startsWith("ping ")) {
                        String str3 = "PONG " + readLine.substring(5) + "\r\n";
                        str3.getBytes();
                        bufferedWriter.write(str3);
                        bufferedWriter.flush();
                    }
                    if (readLine.contains(":(channel is full) transfering you to #")) {
                        this.f5380a.f5130s = readLine.substring(readLine.indexOf(":(channel is full) transfering you to", 1)).replace(":(channel is full) transfering you to ", "").replace("\r", "").replace("\n", "").replace(" ", "");
                    }
                    if (readLine.contains(" 433 *")) {
                        bufferedWriter.write("NICK " + str2 + "_" + "\r\n");
                        bufferedWriter.flush();
                    }
                    if (readLine.contains("376")) {
                        bufferedWriter.write("JOIN " + this.f5380a.f5130s + "\r\n");
                        bufferedWriter.flush();
                        bufferedWriter.flush();
                    }
                    if (readLine.contains("PRIVMSG " + this.f5380a.f5130s + " :")) {
                        this.f5380a.f5102F = m9143a(readLine);
                        this.f5380a.f5104H = m9145b(readLine);
                        this.f5380a.f5103G = m9144a(readLine, this.f5380a.f5130s);
                        this.f5380a.f5103G = this.f5380a.f5103G.replace("<", "");
                        this.f5380a.f5103G = this.f5380a.f5103G.replace(">", "");
                        this.f5380a.f5103G = this.f5380a.f5103G.replace("'", "");
                        this.f5380a.runOnUiThread(new ds(this));
                    }
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
            if (this.f5380a.f5123l != null) {
                this.f5380a.f5123l.close();
                this.f5380a.f5098B = false;
            }
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
            str = "5";
            this.f5380a.f5098B = false;
            try {
                if (this.f5380a.f5123l != null) {
                    this.f5380a.f5123l.close();
                    this.f5380a.f5098B = false;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (IOException e32) {
            e32.printStackTrace();
            this.f5380a.f5098B = false;
            str = "5";
            try {
                if (this.f5380a.f5123l != null) {
                    this.f5380a.f5123l.close();
                    this.f5380a.f5098B = false;
                }
            } catch (IOException e322) {
                e322.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                if (this.f5380a.f5123l != null) {
                    this.f5380a.f5123l.close();
                    this.f5380a.f5098B = false;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }
}
