package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/* renamed from: org.vhack.dev.vhack.do */
class MainActivity implements OnClickListener {
    final /* synthetic */ MainActivity f5378a;

    MainActivity(MainActivity mainActivity) {
        this.f5378a = mainActivity;
    }

    public void onClick(View view) {
        this.f5378a.f5124m.start();
        Editor edit = this.f5378a.getSharedPreferences("ChatData.xml", 0).edit();
        EditText editText = (EditText) this.f5378a.findViewById(2131558850);
        edit.putString("msg", editText.getText().toString().replace("<", "").replace(">", "").replace("'", ""));
        edit.commit();
        editText.setText("");
    }
}
