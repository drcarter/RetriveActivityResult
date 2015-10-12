package retrive.android.drcarter.com.retriveactivityresult.internal.di.module;


import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrive.android.drcarter.com.retriveactivityresult.App;

@Module
public class ApplicationModule {

    private App app;

    public ApplicationModule(@NonNull App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return this.app.getApplicationContext();
    }
}
