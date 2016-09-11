package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/* compiled from: MainActivity */
class cu implements OnClickListener {
    final /* synthetic */ MainActivity a;

    cu(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(View view) {
        this.a.m.start();
        String obj = this.a.I.getText().toString();
        Editor edit = this.a.getSharedPreferences("loginData.xml", 0).edit();
        edit.putString("notepad", obj);
        edit.commit();
        Toast.makeText(this.a, "Saved.", 1).show();
        this.a.a(this.a.I);
    }
}
