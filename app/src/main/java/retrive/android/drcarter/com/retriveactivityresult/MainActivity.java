package retrive.android.drcarter.com.retriveactivityresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import retrive.android.drcarter.com.retriveactivityresult.base.activity.BaseActivity;
import retrive.android.drcarter.com.retriveactivityresult.common.EventBus;
import retrive.android.drcarter.com.retriveactivityresult.event.ActivityResultEvent;
import retrive.android.drcarter.com.retriveactivityresult.fragment.MainFragment;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.component.ActivityComponent;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.component.DaggerMainActivityComponent;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.component.MainActivityComponent;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.module.MainActivityModule;

public class MainActivity extends BaseActivity {

    @Inject
    Bus bus;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getContentViewResource() {
        return R.layout.activity_main;
    }

    @Override
    protected ActivityComponent getInitializeCompoent() {
        return DaggerMainActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build();
    }

    @Override
    protected void onInject(@Nullable ActivityComponent component) {
        if (component != null) {
            ((MainActivityComponent) component).inject(this);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, MainFragment.newInstance()).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        EventBus.getInstance().post(ActivityResultEvent.create(requestCode, resultCode, data));
        bus.post(ActivityResultEvent.create(requestCode, resultCode, data));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.fab)
    public void onFABClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
