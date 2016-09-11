package android.support.v4.p007b;

import android.os.Handler;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: android.support.v4.b.p */
abstract class ModernAsyncTask {
    private static final ThreadFactory f785a;
    private static final BlockingQueue f786b;
    public static final Executor f787c;
    private static ModernAsyncTask f788d;
    private static volatile Executor f789e;
    private final ModernAsyncTask f790f;
    private final FutureTask f791g;
    private volatile ModernAsyncTask f792h;
    private final AtomicBoolean f793i;

    protected abstract Object m1280a(Object... objArr);

    static {
        f785a = new ModernAsyncTask();
        f786b = new LinkedBlockingQueue(10);
        f787c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f786b, f785a);
        f789e = f787c;
    }

    private static Handler m1276d() {
        Handler handler;
        synchronized (ModernAsyncTask.class) {
            if (f788d == null) {
                f788d = new ModernAsyncTask();
            }
            handler = f788d;
        }
        return handler;
    }

    public ModernAsyncTask() {
        this.f792h = ModernAsyncTask.PENDING;
        this.f793i = new AtomicBoolean();
        this.f790f = new ModernAsyncTask(this);
        this.f791g = new ModernAsyncTask(this, this.f790f);
    }

    private void m1275c(Object obj) {
        if (!this.f793i.get()) {
            m1277d(obj);
        }
    }

    private Object m1277d(Object obj) {
        ModernAsyncTask.m1276d().obtainMessage(1, new ModernAsyncTask(this, obj)).sendToTarget();
        return obj;
    }

    protected void m1281a() {
    }

    protected void m1282a(Object obj) {
    }

    protected void m1286b(Object... objArr) {
    }

    protected void m1285b(Object obj) {
        m1284b();
    }

    protected void m1284b() {
    }

    public final boolean m1287c() {
        return this.f791g.isCancelled();
    }

    public final boolean m1283a(boolean z) {
        return this.f791g.cancel(z);
    }

    public final ModernAsyncTask m1279a(Executor executor, Object... objArr) {
        if (this.f792h != ModernAsyncTask.PENDING) {
            switch (ModernAsyncTask.f802a[this.f792h.ordinal()]) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f792h = ModernAsyncTask.RUNNING;
        m1281a();
        this.f790f.f799b = objArr;
        executor.execute(this.f791g);
        return this;
    }

    private void m1278e(Object obj) {
        if (m1287c()) {
            m1285b(obj);
        } else {
            m1282a(obj);
        }
        this.f792h = ModernAsyncTask.FINISHED;
    }
}
