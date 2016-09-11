package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

/* compiled from: NetworkActivity */
class ef implements OnClickListener {
    final /* synthetic */ NetworkActivity a;

    ef(NetworkActivity networkActivity) {
        this.a = networkActivity;
    }

    public void onClick(View view) {
        if (((CheckBox) this.a.findViewById(2131558860)).isChecked()) {
            new en(this.a).execute(new String[]{"1"});
            return;
        }
        new en(this.a).execute(new String[]{"0"});
    }
}
