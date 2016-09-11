package org.vhack.dev.vhack;

import android.widget.ProgressBar;
import android.widget.TextView;

/* renamed from: org.vhack.dev.vhack.y */
class BotnetActivity implements Runnable {
    final /* synthetic */ BotnetActivity f5492a;

    BotnetActivity(BotnetActivity botnetActivity) {
        this.f5492a = botnetActivity;
    }

    public void run() {
        ((TextView) this.f5492a.f5490b.f5488a.f5483a.findViewById(2131558611)).setText("Attacking.. " + this.f5492a.f5489a + "%");
        ProgressBar progressBar = (ProgressBar) this.f5492a.f5490b.f5488a.f5483a.findViewById(2131558610);
        progressBar.setProgress(progressBar.getProgress() + 1);
    }
}
