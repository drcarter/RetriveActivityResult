package retrive.android.drcarter.com.retriveactivityresult.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import retrive.android.drcarter.com.retriveactivityresult.NameInputActivity;
import retrive.android.drcarter.com.retriveactivityresult.R;
import retrive.android.drcarter.com.retriveactivityresult.base.fragment.BaseFragment;
import retrive.android.drcarter.com.retriveactivityresult.common.Constants;
import retrive.android.drcarter.com.retriveactivityresult.common.EventBus;
import retrive.android.drcarter.com.retriveactivityresult.common.KeySets;
import retrive.android.drcarter.com.retriveactivityresult.event.ActivityResultEvent;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.component.MainActivityComponent;

public class MainFragment extends BaseFragment {

    @Inject
    EventBus eventBus;

    @Bind(R.id.text_result)
    TextView textResult;

    public static Fragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getComponent(MainActivityComponent.class).inject(this);
        eventBus.register(this);
    }

    @Override
    public void onDestroyView() {
        eventBus.unregister(this);
        super.onDestroyView();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_input)
    public void onNameInputClick() {

        ActivityCompat.startActivityForResult(getActivity(), new Intent(getActivity(), NameInputActivity.class),
                Constants.RequestCode.REQUEST_CODE_NAME_INPUT, null);

    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onActivityResultEvent(@NonNull ActivityResultEvent event) {
        onActivityResult(event.getRequestCode(), event.getResultCode(), event.getData());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.RequestCode.REQUEST_CODE_NAME_INPUT: {
                if (resultCode == Activity.RESULT_OK) {
                    String text = data.getStringExtra(KeySets.KEY_NAME_INPUT);
                    if (!TextUtils.isEmpty(text)) {
                        textResult.setText(text);
                    }
                }
                break;
            }
        }
    }
}
