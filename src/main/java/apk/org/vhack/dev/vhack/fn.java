package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TasksActivity */
class fn implements OnClickListener {
    final /* synthetic */ TasksActivity a;

    fn(TasksActivity tasksActivity) {
        this.a = tasksActivity;
    }

    public void onClick(View view) {
        new fp(this.a).execute(new String[]{"1", this.a.r});
    }
}
