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
    final /* synthetic */ MainActivity a;

    dq(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public String a(String str) {
        return str.substring(str.indexOf(":") + 1, str.indexOf("!")).replace("v[", "");
    }

    public String b(String str) {
        return str.substring(str.indexOf("@") + 1, str.indexOf("PRIVMSG") - 1);
    }

    public String a(String str, String str2) {
        return str.substring((str.indexOf(str2 + " :") + str2.length()) + 2, str.length());
    }

    public String c(String str) {
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
            this.a.l = new Socket("chat.vhackxt.com", 7531);
            this.a.runOnUiThread(new dr(this));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.a.l.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a.l.getInputStream()));
            Thread dtVar = new dt(this.a, this.a.l);
            new du(this.a, this.a.l).start();
            dtVar.start();
            this.a.s = "#vHackXT";
            this.a.p.replace(" ", "").replace(".", "");
            String str2 = "v[" + c(this.a.p);
            bufferedWriter.write("PASS " + this.a.u + "\r\nNICK " + str2 + "\r\n");
            bufferedWriter.write("USER " + this.a.v + " 0 * : vHack XT@Android\r\n");
            bufferedWriter.flush();
            this.a.getSharedPreferences("ChatData.xml", 0);
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
                        this.a.s = readLine.substring(readLine.indexOf(":(channel is full) transfering you to", 1)).replace(":(channel is full) transfering you to ", "").replace("\r", "").replace("\n", "").replace(" ", "");
                    }
                    if (readLine.contains(" 433 *")) {
                        bufferedWriter.write("NICK " + str2 + "_" + "\r\n");
                        bufferedWriter.flush();
                    }
                    if (readLine.contains("376")) {
                        bufferedWriter.write("JOIN " + this.a.s + "\r\n");
                        bufferedWriter.flush();
                        bufferedWriter.flush();
                    }
                    if (readLine.contains("PRIVMSG " + this.a.s + " :")) {
                        this.a.F = a(readLine);
                        this.a.H = b(readLine);
                        this.a.G = a(readLine, this.a.s);
                        this.a.G = this.a.G.replace("<", "");
                        this.a.G = this.a.G.replace(">", "");
                        this.a.G = this.a.G.replace("'", "");
                        this.a.runOnUiThread(new ds(this));
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
            if (this.a.l != null) {
                this.a.l.close();
                this.a.B = false;
            }
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
            str = "5";
            this.a.B = false;
            try {
                if (this.a.l != null) {
                    this.a.l.close();
                    this.a.B = false;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (IOException e32) {
            e32.printStackTrace();
            this.a.B = false;
            str = "5";
            try {
                if (this.a.l != null) {
                    this.a.l.close();
                    this.a.B = false;
                }
            } catch (IOException e322) {
                e322.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                if (this.a.l != null) {
                    this.a.l.close();
                    this.a.B = false;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }
}
