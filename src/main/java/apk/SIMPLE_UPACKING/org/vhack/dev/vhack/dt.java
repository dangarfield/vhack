package org.vhack.dev.vhack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/* compiled from: MainActivity */
class dt extends Thread {
    Socket f5383a;
    String f5384b;
    BufferedWriter f5385c;
    BufferedReader f5386d;
    final /* synthetic */ MainActivity f5387e;

    dt(MainActivity mainActivity, Socket socket) {
        this.f5387e = mainActivity;
        this.f5384b = null;
        this.f5385c = null;
        this.f5386d = null;
        this.f5383a = socket;
        this.f5385c = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.f5386d = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        this.f5387e.f5116T = true;
        while (this.f5387e.f5116T) {
            if (!this.f5387e.f5098B) {
                try {
                    this.f5385c.write("QUIT \r\n");
                    this.f5385c.flush();
                    this.f5383a.close();
                    this.f5387e.f5116T = false;
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
