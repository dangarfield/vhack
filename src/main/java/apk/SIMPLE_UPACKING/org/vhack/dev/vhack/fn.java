package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TasksActivity */
class fn implements OnClickListener {
    final /* synthetic */ TasksActivity f5464a;

    fn(TasksActivity tasksActivity) {
        this.f5464a = tasksActivity;
    }

    public void onClick(View view) {
        new fp(this.f5464a).execute(new String[]{"1", this.f5464a.f5202r});
    }
}
