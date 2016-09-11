package org.vhack.dev.vhack;

import android.support.v7.b.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

/* compiled from: ClusterActivity */
class aw implements OnClickListener {
    final /* synthetic */ ClusterActivity a;

    aw(ClusterActivity clusterActivity) {
        this.a = clusterActivity;
    }

    public void onClick(View view) {
        EditText editText = (EditText) this.a.findViewById(2131558676);
        String obj = editText.getText().toString();
        if (obj.length() <= 1 || obj.length() >= l.AppCompatTheme_buttonStyleSmall) {
            Toast.makeText(this.a.getApplicationContext(), "Min 2, max 100 characters!", 1).show();
            return;
        }
        this.a.p = obj;
        new bf(this.a).execute(new String[]{obj});
        editText.setText("");
    }
}
