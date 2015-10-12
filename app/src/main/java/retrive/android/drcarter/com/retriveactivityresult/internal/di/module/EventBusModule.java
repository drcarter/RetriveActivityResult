package retrive.android.drcarter.com.retriveactivityresult.internal.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrive.android.drcarter.com.retriveactivityresult.common.EventBus;

@Module
public class EventBusModule {

    @Singleton
    @Provides
    EventBus provideEventBus() {
        return new EventBus();
    }
}
