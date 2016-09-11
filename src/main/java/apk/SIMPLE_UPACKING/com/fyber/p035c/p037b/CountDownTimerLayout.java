package com.fyber.p035c.p037b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fyber.p035c.DrawableLayout;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.fyber.c.b.b */
public final class CountDownTimerLayout extends DrawableLayout {
    private TextView f2648b;
    private Long f2649c;
    private CountDownDrawable f2650d;
    private float f2651e;

    public CountDownTimerLayout(Context context, Long l) {
        super(context);
        this.f2649c = l;
        this.f2651e = 360.0f / ((float) this.f2649c.longValue());
        this.f2648b = new TextView(context);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        this.f2648b.setLayoutParams(layoutParams);
        this.f2648b.setGravity(17);
        this.f2648b.setText(CountDownTimerLayout.m5065b(this.f2649c.longValue()));
        this.f2648b.setTextColor(-1);
        this.f2648b.setContentDescription("countdownTextView");
        int a = m5061a(30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setShape(1);
        gradientDrawable.setAlpha(128);
        gradientDrawable.setSize(a, a);
        gradientDrawable.setUseLevel(false);
        this.f2650d = new CountDownDrawable();
        this.f2650d.m5064a(360.0f);
        m5062a(new LayerDrawable(new Drawable[]{this.f2650d, gradientDrawable}));
        addView(this.f2648b);
        setContentDescription("countdownView");
    }

    public final void m5066a(long j) {
        long longValue = this.f2649c.longValue() - j;
        if (longValue >= 0) {
            this.f2648b.setText(CountDownTimerLayout.m5065b(longValue));
            this.f2650d.m5064a(((float) longValue) * this.f2651e);
        }
    }

    private static String m5065b(long j) {
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(j);
        if (toSeconds <= 59) {
            return Long.valueOf(toSeconds).toString();
        }
        return String.format(Locale.ENGLISH, "%d:%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) % TimeUnit.HOURS.toMinutes(1)), Long.valueOf(toSeconds % TimeUnit.MINUTES.toSeconds(1))});
    }
}
