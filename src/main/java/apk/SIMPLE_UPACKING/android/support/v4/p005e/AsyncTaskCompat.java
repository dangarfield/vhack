package android.support.v4.p005e;

import android.os.AsyncTask;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.e.a */
public final class AsyncTaskCompat {
    public static AsyncTask m1430a(AsyncTask asyncTask, Object... objArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            AsyncTaskCompatHoneycomb.m1431a(asyncTask, objArr);
        } else {
            asyncTask.execute(objArr);
        }
        return asyncTask;
    }
}
