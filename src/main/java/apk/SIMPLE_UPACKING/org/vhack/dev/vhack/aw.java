package org.vhack.dev.vhack;

import android.support.v7.p018b.R;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

/* compiled from: ClusterActivity */
class aw implements OnClickListener {
    final /* synthetic */ ClusterActivity f5282a;

    aw(ClusterActivity clusterActivity) {
        this.f5282a = clusterActivity;
    }

    public void onClick(View view) {
        EditText editText = (EditText) this.f5282a.findViewById(2131558676);
        String obj = editText.getText().toString();
        if (obj.length() <= 1 || obj.length() >= R.AppCompatTheme_buttonStyleSmall) {
            Toast.makeText(this.f5282a.getApplicationContext(), "Min 2, max 100 characters!", 1).show();
            return;
        }
        this.f5282a.f5033p = obj;
        new bf(this.f5282a).execute(new String[]{obj});
        editText.setText("");
    }
}
