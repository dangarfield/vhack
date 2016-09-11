package org.vhack.dev.vhack;

/* compiled from: DelayedVerticalScrollingTextView */
class bp implements Runnable {
    final /* synthetic */ DelayedVerticalScrollingTextView f5308a;

    bp(DelayedVerticalScrollingTextView delayedVerticalScrollingTextView) {
        this.f5308a = delayedVerticalScrollingTextView;
    }

    public void run() {
        String str = (String) this.f5308a.f5051b.poll();
        if (str != null) {
            this.f5308a.f5050a.append(str);
            this.f5308a.f5050a.append("\n");
            this.f5308a.setText("vHack XT [Version 1.15]\n\n" + this.f5308a.f5050a);
            if (this.f5308a.f5051b.isEmpty()) {
                this.f5308a.removeCallbacks(this);
            } else {
                this.f5308a.postDelayed(this, (long) this.f5308a.f5052c);
            }
        }
    }
}
