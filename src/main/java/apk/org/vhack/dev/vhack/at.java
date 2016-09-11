package org.vhack.dev.vhack;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ClusterActivity */
class at implements OnClickListener {
    final /* synthetic */ ClusterActivity a;

    at(ClusterActivity clusterActivity) {
        this.a = clusterActivity;
    }

    public void onClick(View view) {
        Builder builder = new Builder(this.a);
        builder.setCancelable(false);
        builder.setMessage(2131165395);
        builder.setPositiveButton(2131165262, new au(this));
        builder.setNegativeButton(2131165261, new av(this));
        builder.create().show();
    }
}
