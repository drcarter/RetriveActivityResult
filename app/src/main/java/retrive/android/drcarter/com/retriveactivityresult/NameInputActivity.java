package retrive.android.drcarter.com.retriveactivityresult;

import android.content.Intent;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.OnClick;
import retrive.android.drcarter.com.retriveactivityresult.common.KeySets;

public class NameInputActivity extends BaseActivity {

    @Bind(R.id.edit_input)
    EditText editNameInput;

    @Override
    protected int getContentViewResource() {
        return R.layout.activity_name_input;
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
