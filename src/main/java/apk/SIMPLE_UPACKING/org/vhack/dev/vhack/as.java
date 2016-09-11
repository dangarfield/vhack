package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/* compiled from: ClusterActivity */
class as implements OnClickListener {
    final /* synthetic */ ClusterActivity f5278a;

    as(ClusterActivity clusterActivity) {
        this.f5278a = clusterActivity;
    }

    public void onClick(View view) {
        if (!((EditText) this.f5278a.findViewById(2131558635)).getText().toString().equals("")) {
            new bd(this.f5278a).execute(new String[]{r0});
        }
    }
}
