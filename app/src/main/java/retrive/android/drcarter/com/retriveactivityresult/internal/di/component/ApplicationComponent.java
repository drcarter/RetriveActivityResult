package retrive.android.drcarter.com.retriveactivityresult.internal.di.component;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;
import retrive.android.drcarter.com.retriveactivityresult.common.EventBus;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.module.ApplicationModule;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.module.EventBusModule;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                EventBusModule.class
        }
)
public interface ApplicationComponent {

        Bus getEventBus();

}
