package spinner.spinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cpn_sp)
    CpnCustomSpinner mCpnCustomSpinner;
    private List<SpinnerModel> mItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SpinnerModel hello = new SpinnerModel("Hello");
        SpinnerModel welcome = new SpinnerModel("welcome");

        mItemList.add(hello);
        mItemList.add(welcome);
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this, mItemList);
        mCpnCustomSpinner.setAdapter(spinnerAdapter);


        mCpnCustomSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("", "" + mItemList.get(position).getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mCpnCustomSpinner.setSelection(1);
    }
}
