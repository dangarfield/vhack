package org.vhack.dev.vhack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/* compiled from: MainActivity */
class dt extends Thread {
    Socket a;
    String b;
    BufferedWriter c;
    BufferedReader d;
    final /* synthetic */ MainActivity e;

    dt(MainActivity mainActivity, Socket socket) {
        this.e = mainActivity;
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = socket;
        this.c = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.d = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        this.e.T = true;
        while (this.e.T) {
            if (!this.e.B) {
                try {
                    this.c.write("QUIT \r\n");
                    this.c.flush();
                    this.a.close();
                    this.e.T = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }
}
