package retrive.android.drcarter.com.retriveactivityresult.internal.di.component;

import android.support.annotation.NonNull;

import dagger.Component;
import retrive.android.drcarter.com.retriveactivityresult.MainActivity;
import retrive.android.drcarter.com.retriveactivityresult.fragment.MainFragment;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.PerActivity;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.module.MainActivityModule;

@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                MainActivityModule.class
        }
)
public interface MainActivityComponent extends ActivityComponent{
        void inject(@NonNull MainActivity mainActivity);
        void inject(@NonNull MainFragment mainFragment);
}
