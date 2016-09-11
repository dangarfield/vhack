package org.vhack.dev.vhack;

/* compiled from: DelayedVerticalScrollingTextView */
class bp implements Runnable {
    final /* synthetic */ DelayedVerticalScrollingTextView a;

    bp(DelayedVerticalScrollingTextView delayedVerticalScrollingTextView) {
        this.a = delayedVerticalScrollingTextView;
    }

    public void run() {
        String str = (String) this.a.b.poll();
        if (str != null) {
            this.a.a.append(str);
            this.a.a.append("\n");
            this.a.setText("vHack XT [Version 1.15]\n\n" + this.a.a);
            if (this.a.b.isEmpty()) {
                this.a.removeCallbacks(this);
            } else {
                this.a.postDelayed(this, (long) this.a.c);
            }
        }
    }
}
