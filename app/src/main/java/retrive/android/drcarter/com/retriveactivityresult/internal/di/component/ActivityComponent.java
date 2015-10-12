package retrive.android.drcarter.com.retriveactivityresult.internal.di.component;

import dagger.Component;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.PerActivity;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.module.ActivityModule;

@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = ActivityModule.class
)
public interface ActivityComponent {
}
