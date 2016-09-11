package com.fyber.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.fyber.cache.p039a.CacheStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.fyber.utils.k */
public final class FyberPersistence {
    public static void m5276a(Context context) {
        Exception e;
        String str;
        StringBuilder stringBuilder;
        String str2;
        SharedPreferences sharedPreferences = context.getSharedPreferences("migration", 0);
        if (!sharedPreferences.getBoolean("successfulMigration", false)) {
            FyberPersistence.m5275a(context, "ConfigurationRequester", "MediationConfigurationNetworkOperation");
            FyberPersistence.m5275a(context, "SPStatistics", "FyberStatistics");
            FyberPersistence.m5275a(context, "SponsorPayPublisherState", "FyberPreferences");
            FyberPersistence.m5275a(context, "SponsorPayCookiePrefsFile", "FyberCookiePrefsFile");
            FyberPersistence.m5275a(context, "SponsorPayAdvertiserState", "FyberPreferences");
            File file = new File(context.getFilesDir(), "FyberCacheStorage");
            File file2 = new File(context.getFilesDir(), "SPCacheStorage");
            if (file2.exists() && file2.renameTo(file)) {
                FyberLogger.m5226c("FyberPersistence", "File:" + file2.getName() + " has been successfully renamed.");
            }
            FyberLogger.m5223b("FyberPersistence", "Checking previous cache directory");
            if ("mounted".equals(Environment.getExternalStorageState())) {
                boolean z;
                if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    FyberLogger.m5223b("FyberPersistence", "External write storage permission granted");
                    File file3 = new File(Environment.getExternalStorageDirectory(), "VideoCache" + File.separator + context.getPackageName().hashCode());
                    if (file3.exists()) {
                        FyberLogger.m5223b("FyberPersistence", "Application cache directory exists, deleting...");
                        FyberPersistence.m5277a(file3);
                        file3.delete();
                    }
                    File[] listFiles = file3.getParentFile().listFiles();
                    if (listFiles != null && listFiles.length == 0) {
                        FyberLogger.m5223b("FyberPersistence", "Cache directory empty, deleting...");
                        file3.getParentFile().delete();
                    }
                    sharedPreferences.edit().putBoolean("successfulMigration", true).commit();
                }
            }
            file = new File(context.getFilesDir(), "VideoCache");
            if (file.exists()) {
                FyberLogger.m5223b("FyberPersistence", "Internal cache directory exists, deleting...");
                FyberPersistence.m5277a(file);
                file.delete();
            }
            sharedPreferences.edit().putBoolean("successfulMigration", true).commit();
        }
        if (!sharedPreferences.getBoolean("protocolMigration", false)) {
            File file4 = new File(context.getFilesDir().getAbsolutePath(), "FyberCacheStorage");
            if (file4.exists()) {
                InputStream fileInputStream = new FileInputStream(file4);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    HashMap hashMap = (HashMap) objectInputStream.readObject();
                    SharedPreferences sharedPreferences2 = context.getSharedPreferences("FyberCacheStorage", 0);
                    sharedPreferences2.edit().putString("FyberCacheStorage", CacheStore.m5105a(hashMap.values())).apply();
                } catch (IOException e2) {
                    e = e2;
                    try {
                        FyberLogger.m5223b("FyberPersistence", "There was an exception migrating the old cache information - " + e.getMessage());
                        objectInputStream.close();
                        fileInputStream.close();
                        str = "FyberPersistence";
                        stringBuilder = new StringBuilder("Removing old cache file info - ");
                        if (file4.delete()) {
                            str2 = "unsuccessful";
                        } else {
                            str2 = "successful";
                        }
                        FyberLogger.m5223b(str, stringBuilder.append(str2).toString());
                    } catch (IOException e3) {
                        FyberLogger.m5223b("FyberPersistence", "There was an exception migrating the old cache information - " + e3.getMessage());
                    }
                    sharedPreferences.edit().putBoolean("protocolMigration", true).commit();
                } catch (ClassNotFoundException e4) {
                    e = e4;
                    FyberLogger.m5223b("FyberPersistence", "There was an exception migrating the old cache information - " + e.getMessage());
                    objectInputStream.close();
                    fileInputStream.close();
                    str = "FyberPersistence";
                    stringBuilder = new StringBuilder("Removing old cache file info - ");
                    if (file4.delete()) {
                        str2 = "successful";
                    } else {
                        str2 = "unsuccessful";
                    }
                    FyberLogger.m5223b(str, stringBuilder.append(str2).toString());
                    sharedPreferences.edit().putBoolean("protocolMigration", true).commit();
                }
                objectInputStream.close();
                fileInputStream.close();
                str = "FyberPersistence";
                stringBuilder = new StringBuilder("Removing old cache file info - ");
                if (file4.delete()) {
                    str2 = "successful";
                } else {
                    str2 = "unsuccessful";
                }
                FyberLogger.m5223b(str, stringBuilder.append(str2).toString());
            }
            sharedPreferences.edit().putBoolean("protocolMigration", true).commit();
        }
    }

    private static SharedPreferences m5275a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        Map all = sharedPreferences.getAll();
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(str2, 0);
        if (!all.isEmpty()) {
            Editor edit = sharedPreferences2.edit();
            for (Entry entry : sharedPreferences.getAll().entrySet()) {
                String replace;
                Object value = entry.getValue();
                String str3 = (String) entry.getKey();
                if (str3.contains("SponsorPayAdvertiserState")) {
                    replace = str3.replace("SponsorPayAdvertiserState", "AdvertiserAnswerReceived");
                } else {
                    replace = str3;
                }
                if (value instanceof String) {
                    edit.putString(replace, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(replace, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(replace, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    edit.putFloat(replace, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(replace, ((Boolean) value).booleanValue());
                }
            }
            edit.commit();
            sharedPreferences.edit().clear().commit();
        }
        File file = new File(context.getApplicationInfo().dataDir + File.separator + "shared_prefs" + File.separator + str + ".xml");
        if (file.exists() && file.delete()) {
            FyberLogger.m5226c("FyberPersistence", "SharedPreferences " + str + ", have been deleted.");
        }
        return sharedPreferences2;
    }

    private static void m5277a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }
}
