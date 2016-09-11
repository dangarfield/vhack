package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.ads.internal.util.client.C0099b;

/* renamed from: com.google.android.gms.ads.internal.purchase.f */
public class C0085f extends SQLiteOpenHelper {
    final /* synthetic */ C0084e f3084a;

    public C0085f(C0084e c0084e, Context context, String str) {
        this.f3084a = c0084e;
        super(context, str, null, 4);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(C0084e.f3080a);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0099b.m5641c("Database updated from version " + i + " to version " + i2);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
        onCreate(sQLiteDatabase);
    }
}
