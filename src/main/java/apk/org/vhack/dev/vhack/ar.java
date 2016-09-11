package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/* compiled from: ClusterActivity */
class ar implements OnClickListener {
    final /* synthetic */ ClusterActivity a;

    ar(ClusterActivity clusterActivity) {
        this.a = clusterActivity;
    }

    public void onClick(View view) {
        String obj = ((EditText) this.a.findViewById(2131558640)).getText().toString();
        String obj2 = ((EditText) this.a.findViewById(2131558639)).getText().toString();
        if (!obj.equals("") && !obj2.equals("")) {
            new bc(this.a).execute(new String[]{obj2, obj});
        }
    }
}
