package retrive.android.drcarter.com.retriveactivityresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.OnClick;
import retrive.android.drcarter.com.retriveactivityresult.common.KeySets;
import retrive.android.drcarter.com.retriveactivityresult.internal.di.component.ActivityComponent;

public class NameInputActivity extends BaseActivity {

    @Bind(R.id.edit_input)
    EditText editNameInput;

    @Override
    protected int getContentViewResource() {
        return R.layout.activity_name_input;
    }

    @Override
    protected ActivityComponent getInitializeCompoent() {
        return null;
    }

    @Override
    protected void onInject(@Nullable ActivityComponent component) {

    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_callback)
    public void onNameInputCallback() {
        String text = editNameInput.getText().toString().trim();

        Intent intent = new Intent();
        intent.putExtra(KeySets.KEY_NAME_INPUT, text);
        setResult(RESULT_OK, intent);
        finish();
    }
}
