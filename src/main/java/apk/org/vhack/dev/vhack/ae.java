package org.vhack.dev.vhack;

import android.widget.ProgressBar;
import android.widget.TextView;

/* compiled from: BotnetActivity */
class ae implements Runnable {
    final /* synthetic */ ac a;

    ae(ac acVar) {
        this.a = acVar;
    }

    public void run() {
        ((TextView) this.a.b.a.a.findViewById(2131558620)).setText("Attacking.. " + this.a.a + "%");
        ProgressBar progressBar = (ProgressBar) this.a.b.a.a.findViewById(2131558617);
        progressBar.setProgress(progressBar.getProgress() + 1);
    }
}
