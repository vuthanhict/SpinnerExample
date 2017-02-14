package spinner.spinnerexample;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ThanhVV
 * @since 2/14/2017.
 */

public class SpinnerAdapter extends BaseSpinnerAdapter {
    public SpinnerAdapter(Context context, List<SpinnerModel> items) {
        super(context, new ArrayList<Object>(items));
    }

    @Override
    protected String getText(Object object) {
        return ((SpinnerModel) object).getText();
    }
}
