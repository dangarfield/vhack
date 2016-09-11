package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

/* compiled from: NetworkActivity */
class ef implements OnClickListener {
    final /* synthetic */ NetworkActivity f5405a;

    ef(NetworkActivity networkActivity) {
        this.f5405a = networkActivity;
    }

    public void onClick(View view) {
        if (((CheckBox) this.f5405a.findViewById(2131558860)).isChecked()) {
            new en(this.f5405a).execute(new String[]{"1"});
            return;
        }
        new en(this.f5405a).execute(new String[]{"0"});
    }
}
