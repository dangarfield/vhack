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
    Socket a;
    String b;
    BufferedWriter c;
    BufferedReader d;
    final /* synthetic */ MainActivity e;

    du(MainActivity mainActivity, Socket socket) {
        this.e = mainActivity;
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = socket;
        this.c = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.d = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        while (this.e.B) {
            try {
                SharedPreferences sharedPreferences = this.e.getSharedPreferences("ChatData.xml", 0);
                this.e.V = sharedPreferences.getString("msg", "");
                if (!(this.e.V.equals(this.e.J) || this.e.V.equals(""))) {
                    this.e.V = this.e.V.replace("<", "");
                    this.e.V = this.e.V.replace(">", "");
                    this.e.V = this.e.V.replace("'", "");
                    String str = "";
                    if (!Pattern.compile("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)").matcher(this.e.V).find()) {
                        this.c.write("PRIVMSG " + this.e.s + " :" + this.e.V + "\r\n");
                        this.c.flush();
                    }
                    this.e.runOnUiThread(new dv(this));
                    this.e.J = this.e.V;
                }
                if (!this.e.B) {
                    this.b = "QUIT";
                    this.c.write(this.b + "\r\n");
                    this.c.flush();
                }
                this.b = this.d.readLine();
                if (this.b != null) {
                    this.c.write(this.b + "\r\n");
                    this.c.flush();
                }
            } catch (IOException e) {
                this.e.B = false;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e2) {
                this.e.B = false;
            }
        }
    }
}
