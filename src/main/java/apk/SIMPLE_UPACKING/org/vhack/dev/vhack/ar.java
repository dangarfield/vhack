package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/* compiled from: ClusterActivity */
class ar implements OnClickListener {
    final /* synthetic */ ClusterActivity f5277a;

    ar(ClusterActivity clusterActivity) {
        this.f5277a = clusterActivity;
    }

    public void onClick(View view) {
        String obj = ((EditText) this.f5277a.findViewById(2131558640)).getText().toString();
        String obj2 = ((EditText) this.f5277a.findViewById(2131558639)).getText().toString();
        if (!obj.equals("") && !obj2.equals("")) {
            new bc(this.f5277a).execute(new String[]{obj2, obj});
        }
    }
}
