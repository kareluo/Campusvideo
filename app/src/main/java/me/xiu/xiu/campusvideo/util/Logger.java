package me.xiu.xiu.campusvideo.util;

import android.util.Log;

import com.elvishew.xlog.XLog;

import me.xiu.xiu.campusvideo.BuildConfig;
import me.xiu.xiu.campusvideo.common.CampusVideo;

/**
 * Created by felix on 15/9/18.
 */
public class Logger {

    private static final boolean DEBUG = CampusVideo.DEBUG;

    public static void init() {
        XLog.init();
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
        XLog.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (DEBUG) {
            Log.i(tag, msg);
        }
        XLog.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (DEBUG) {
            Log.w(tag, msg);
        }
        XLog.w(tag, msg);
    }

    public static void w(String tag, Throwable tr) {
        if (DEBUG) {
            Log.w(tag, tr);
        }
        XLog.w(tag, tr);
    }

    private static void w(String tag, String message, Throwable tr) {
        if (DEBUG) {
            Log.w(tag, tr);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void e(String tag, Throwable tr) {
        if (DEBUG) {
            Log.e(tag, "", tr);
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (DEBUG) {
            Log.e(tag, msg, tr);
        }
    }
}
