package org.vhack.dev.vhack;

import android.widget.ProgressBar;
import android.widget.TextView;

/* compiled from: BotnetActivity */
class ae implements Runnable {
    final /* synthetic */ ac f5260a;

    ae(ac acVar) {
        this.f5260a = acVar;
    }

    public void run() {
        ((TextView) this.f5260a.f5258b.f5256a.f5483a.findViewById(2131558620)).setText("Attacking.. " + this.f5260a.f5257a + "%");
        ProgressBar progressBar = (ProgressBar) this.f5260a.f5258b.f5256a.f5483a.findViewById(2131558617);
        progressBar.setProgress(progressBar.getProgress() + 1);
    }
}
