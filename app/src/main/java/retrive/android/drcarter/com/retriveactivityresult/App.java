package retrive.android.drcarter.com.retriveactivityresult;

import android.app.Application;

import retrive.android.drcarter.com.retriveactivityresult.internal.di.component.ApplicationComponent;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.component.DaggerApplicationComponent;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.module.ApplicationModule;

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initApplicationComponent();
    }

    private void initApplicationComponent() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
