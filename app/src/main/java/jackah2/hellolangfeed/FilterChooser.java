package jackah2.hellolangfeed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class FilterChooser extends AppCompatActivity {

    private TextView languageText, typeText, statusText;
    private Spinner languageSel, typeSel, statusSel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_chooser);

        languageText = (TextView) findViewById(R.id.language_select_text);
        typeText = (TextView) findViewById(R.id.user_type_select_text);
        statusText = (TextView) findViewById(R.id.status_select_text);

        languageSel = (Spinner) findViewById(R.id.language_select_spinner);
        typeSel = (Spinner) findViewById(R.id.user_type_select_spinner);
        statusSel = (Spinner) findViewById(R.id.status_select_spinner);

        languageText.setText(R.string.language_selector);
        typeText.setText(R.string.type_selector);
        statusText.setText(R.string.status_selector);

        languageSel.setAdapter(getAdapter(R.array.languages));
        typeSel.setAdapter(getAdapter(R.array.types));
        statusSel.setAdapter(getAdapter(R.array.statuses));
    }

    private ArrayAdapter<CharSequence> getAdapter(int textArrayResId){
        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this, textArrayResId,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }
}
