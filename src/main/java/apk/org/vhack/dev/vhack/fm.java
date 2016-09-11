package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TasksActivity */
class fm implements OnClickListener {
    final /* synthetic */ TasksActivity a;

    fm(TasksActivity tasksActivity) {
        this.a = tasksActivity;
    }

    public void onClick(View view) {
        new fp(this.a).execute(new String[]{"2", this.a.r});
    }
}
