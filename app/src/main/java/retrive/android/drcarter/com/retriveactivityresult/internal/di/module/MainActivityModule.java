package retrive.android.drcarter.com.retriveactivityresult.internal.di.module;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import dagger.Module;
import retrive.android.drcarter.com.retriveactivityresult.MainActivity;

@Module
public class MainActivityModule {
    private WeakReference<MainActivity> activityWeakReference;

    public MainActivityModule(@NonNull MainActivity mainActivity) {
        this.activityWeakReference = new WeakReference<MainActivity>(mainActivity);
    }
}
