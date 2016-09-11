package com.google.android.gms.measurement.internal;

public final class av {
    public static aw f4691A;
    public static aw f4692a;
    public static aw f4693b;
    public static aw f4694c;
    public static aw f4695d;
    public static aw f4696e;
    public static aw f4697f;
    public static aw f4698g;
    public static aw f4699h;
    public static aw f4700i;
    public static aw f4701j;
    public static aw f4702k;
    public static aw f4703l;
    public static aw f4704m;
    public static aw f4705n;
    public static aw f4706o;
    public static aw f4707p;
    public static aw f4708q;
    public static aw f4709r;
    public static aw f4710s;
    public static aw f4711t;
    public static aw f4712u;
    public static aw f4713v;
    public static aw f4714w;
    public static aw f4715x;
    public static aw f4716y;
    public static aw f4717z;

    static {
        f4692a = aw.m8486a("measurement.service_enabled", true);
        f4693b = aw.m8486a("measurement.service_client_enabled", true);
        f4694c = aw.m8485a("measurement.log_tag", "GMPM", "GMPM-SVC");
        f4695d = aw.m8482a("measurement.ad_id_cache_time", 10000);
        f4696e = aw.m8482a("measurement.monitoring.sample_period_millis", 86400000);
        f4697f = aw.m8482a("measurement.config.cache_time", 86400000);
        f4698g = aw.m8484a("measurement.config.url_scheme", "https");
        f4699h = aw.m8484a("measurement.config.url_authority", "app-measurement.com");
        f4700i = aw.m8480a("measurement.upload.max_bundles", 100);
        f4701j = aw.m8480a("measurement.upload.max_batch_size", 65536);
        f4702k = aw.m8480a("measurement.upload.max_bundle_size", 65536);
        f4703l = aw.m8480a("measurement.upload.max_events_per_bundle", 1000);
        f4704m = aw.m8480a("measurement.upload.max_events_per_day", 100000);
        f4705n = aw.m8480a("measurement.upload.max_public_events_per_day", 50000);
        f4706o = aw.m8480a("measurement.upload.max_conversions_per_day", 500);
        f4707p = aw.m8480a("measurement.store.max_stored_events_per_app", 100000);
        f4708q = aw.m8484a("measurement.upload.url", "https://app-measurement.com/a");
        f4709r = aw.m8482a("measurement.upload.backoff_period", 43200000);
        f4710s = aw.m8482a("measurement.upload.window_interval", 3600000);
        f4711t = aw.m8482a("measurement.upload.interval", 3600000);
        f4712u = aw.m8482a("measurement.upload.stale_data_deletion_interval", 86400000);
        f4713v = aw.m8482a("measurement.upload.initial_upload_delay_time", 15000);
        f4714w = aw.m8482a("measurement.upload.retry_time", 1800000);
        f4715x = aw.m8480a("measurement.upload.retry_count", 6);
        f4716y = aw.m8482a("measurement.upload.max_queue_time", 2419200000L);
        f4717z = aw.m8480a("measurement.lifetimevalue.max_currency_tracked", 4);
        f4691A = aw.m8482a("measurement.service_client.idle_disconnect_millis", 5000);
    }
}
