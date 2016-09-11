package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/* compiled from: ClusterActivity */
class as implements OnClickListener {
    final /* synthetic */ ClusterActivity a;

    as(ClusterActivity clusterActivity) {
        this.a = clusterActivity;
    }

    public void onClick(View view) {
        if (!((EditText) this.a.findViewById(2131558635)).getText().toString().equals("")) {
            new bd(this.a).execute(new String[]{r0});
        }
    }
}
