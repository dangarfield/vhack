package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TasksActivity */
class fm implements OnClickListener {
    final /* synthetic */ TasksActivity f5463a;

    fm(TasksActivity tasksActivity) {
        this.f5463a = tasksActivity;
    }

    public void onClick(View view) {
        new fp(this.f5463a).execute(new String[]{"2", this.f5463a.f5202r});
    }
}
