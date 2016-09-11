package org.vhack.dev.vhack;

import java.util.TimerTask;

/* compiled from: TasksActivity */
class fk extends TimerTask {
    final /* synthetic */ TasksActivity f5461a;

    fk(TasksActivity tasksActivity) {
        this.f5461a = tasksActivity;
    }

    public void run() {
        this.f5461a.runOnUiThread(new fl(this));
    }
}
