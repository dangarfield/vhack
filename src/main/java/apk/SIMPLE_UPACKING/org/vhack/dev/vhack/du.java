package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.regex.Pattern;

/* compiled from: MainActivity */
class du extends Thread {
    Socket f5388a;
    String f5389b;
    BufferedWriter f5390c;
    BufferedReader f5391d;
    final /* synthetic */ MainActivity f5392e;

    du(MainActivity mainActivity, Socket socket) {
        this.f5392e = mainActivity;
        this.f5389b = null;
        this.f5390c = null;
        this.f5391d = null;
        this.f5388a = socket;
        this.f5390c = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.f5391d = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        while (this.f5392e.f5098B) {
            try {
                SharedPreferences sharedPreferences = this.f5392e.getSharedPreferences("ChatData.xml", 0);
                this.f5392e.f5118V = sharedPreferences.getString("msg", "");
                if (!(this.f5392e.f5118V.equals(this.f5392e.f5106J) || this.f5392e.f5118V.equals(""))) {
                    this.f5392e.f5118V = this.f5392e.f5118V.replace("<", "");
                    this.f5392e.f5118V = this.f5392e.f5118V.replace(">", "");
                    this.f5392e.f5118V = this.f5392e.f5118V.replace("'", "");
                    String str = "";
                    if (!Pattern.compile("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)").matcher(this.f5392e.f5118V).find()) {
                        this.f5390c.write("PRIVMSG " + this.f5392e.f5130s + " :" + this.f5392e.f5118V + "\r\n");
                        this.f5390c.flush();
                    }
                    this.f5392e.runOnUiThread(new dv(this));
                    this.f5392e.f5106J = this.f5392e.f5118V;
                }
                if (!this.f5392e.f5098B) {
                    this.f5389b = "QUIT";
                    this.f5390c.write(this.f5389b + "\r\n");
                    this.f5390c.flush();
                }
                this.f5389b = this.f5391d.readLine();
                if (this.f5389b != null) {
                    this.f5390c.write(this.f5389b + "\r\n");
                    this.f5390c.flush();
                }
            } catch (IOException e) {
                this.f5392e.f5098B = false;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e2) {
                this.f5392e.f5098B = false;
            }
        }
    }
}
