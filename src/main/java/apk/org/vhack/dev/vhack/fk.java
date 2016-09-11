package org.vhack.dev.vhack;

import java.util.TimerTask;

/* compiled from: TasksActivity */
class fk extends TimerTask {
    final /* synthetic */ TasksActivity a;

    fk(TasksActivity tasksActivity) {
        this.a = tasksActivity;
    }

    public void run() {
        this.a.runOnUiThread(new fl(this));
    }
}
