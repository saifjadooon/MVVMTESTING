package com.example.mvvmtesting;

import android.app.Application;

import com.example.mvvmtesting.Essentials.Constants;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        hInitTimber();
    }

    private void hInitTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected void log(int priority, String tag, @NotNull String message, Throwable t) {
                    super.log(priority, String.format(Constants.hTag, tag), message, t);
                }
            });
        }
    }
}
