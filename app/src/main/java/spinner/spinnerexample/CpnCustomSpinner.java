package spinner.spinnerexample;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ThanhVV
 * @since 2/14/2017.
 */

public class CpnCustomSpinner extends LinearLayout {
    @BindView(R.id.llSpinner)
    LinearLayout mLlSpinner;
    @BindView(R.id.spinner)
    Spinner mSpinner;
    private int mBackgroundType;

    public CpnCustomSpinner(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CpnCustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CpnCustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CpnCustomSpinner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable
                .CpnCustomSpinner, defStyle, 0);

        mBackgroundType = a.getInt(R.styleable.CpnCustomSpinner_backgroundType, 0);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.cpn_custom_spinner, this, true);

        ButterKnife.bind(this);
        updateView();
    }

    private void updateView() {
        if (mBackgroundType == 1) {
            mLlSpinner.setBackgroundResource(R.drawable.bg_bt);
        }
    }

    public void setAdapter(SpinnerAdapter adapter) {
        mSpinner.setAdapter(adapter);
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener listener) {
        mSpinner.setOnItemSelectedListener(listener);
    }

    public void setSelection(int position) {
        mSpinner.setSelection(position);
    }

    public Object getSelectedItem() {
        return mSpinner.getSelectedItem();
    }

    @Override
    public void setFocusable(boolean value) {
        mLlSpinner.setFocusable(value);
        mSpinner.setEnabled(value);
        mSpinner.setClickable(value);
    }
}
