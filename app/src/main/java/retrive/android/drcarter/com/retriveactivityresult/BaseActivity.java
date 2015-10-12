package retrive.android.drcarter.com.retriveactivityresult;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.component.ActivityComponent;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.component.ApplicationComponent;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.component.HasComponent;

public abstract class BaseActivity extends AppCompatActivity implements HasComponent<ActivityComponent> {

    protected abstract int getContentViewResource();

    protected abstract ActivityComponent getInitializeCompoent();

    protected abstract void onInject(@Nullable ActivityComponent component);

    protected ActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResource());

        ButterKnife.bind(this);

        this.component = getInitializeCompoent();
        if (this.component != null) {
            onInject(this.component);
        }
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((App) getApplication()).getApplicationComponent();
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    @Override
    public ActivityComponent getComponent() {
        return this.component;
    }
}
