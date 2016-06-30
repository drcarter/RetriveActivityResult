package retrive.android.drcarter.com.retriveactivityresult.internal.di.module;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrive.android.drcarter.com.retriveactivityresult.common.EventBus;

@Module
public class EventBusModule {

    @Singleton
    @Provides
    Bus provideEventBus() {
        return new EventBus();
    }
}
