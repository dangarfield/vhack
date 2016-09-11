package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.p017a.AlertDialog;
import android.support.v7.p018b.R;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/* renamed from: android.support.v7.view.menu.l */
class MenuDialogHelper implements OnClickListener, OnDismissListener, OnKeyListener, MenuPresenter {
    ListMenuPresenter f1526a;
    private MenuBuilder f1527b;
    private AlertDialog f1528c;
    private MenuPresenter f1529d;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f1527b = menuBuilder;
    }

    public void m3320a(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f1527b;
        AlertDialog alertDialog = new AlertDialog(menuBuilder.m3243e());
        this.f1526a = new ListMenuPresenter(alertDialog.m3081a(), R.abc_list_menu_item_layout);
        this.f1526a.m3311a((MenuPresenter) this);
        this.f1527b.m3223a(this.f1526a);
        alertDialog.m3085a(this.f1526a.m3308a(), this);
        View o = menuBuilder.m3253o();
        if (o != null) {
            alertDialog.m3084a(o);
        } else {
            alertDialog.m3083a(menuBuilder.m3252n()).m3086a(menuBuilder.m3251m());
        }
        alertDialog.m3082a((OnKeyListener) this);
        this.f1528c = alertDialog.m3087b();
        this.f1528c.setOnDismissListener(this);
        LayoutParams attributes = this.f1528c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1528c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f1528c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f1528c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f1527b.m3227a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f1527b.performShortcut(i, keyEvent, 0);
    }

    public void m3319a() {
        if (this.f1528c != null) {
            this.f1528c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f1526a.m3310a(this.f1527b, true);
    }

    public void m3321a(MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.f1527b) {
            m3319a();
        }
        if (this.f1529d != null) {
            this.f1529d.m2871a(menuBuilder, z);
        }
    }

    public boolean m3322a(MenuBuilder menuBuilder) {
        if (this.f1529d != null) {
            return this.f1529d.m2872a(menuBuilder);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1527b.m3229a((MenuItemImpl) this.f1526a.m3308a().getItem(i), 0);
    }
}
