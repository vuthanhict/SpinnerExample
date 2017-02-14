package spinner.spinnerexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ThanhVV
 * @since 2/14/2017.
 */

public abstract class BaseSpinnerAdapter extends ArrayAdapter<Object> {
    private Context mContext;
    private LayoutInflater mInflater;

    protected abstract String getText(Object object);

    public BaseSpinnerAdapter(Context context, List<Object> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_spiner, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Object item = getItem(position);
        if (item == null) {
            return convertView;
        }
        holder.tvText.setText(getText(item));
        return convertView;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        final DropdownViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_spiner_dropdown, parent, false);
            holder = new DropdownViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (DropdownViewHolder) convertView.getTag();
        }

        final Object item = getItem(position);
        if (item == null) {
            return convertView;
        }
        holder.tvText.setText(getText(item));
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.tvText)
        TextView tvText;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    class DropdownViewHolder {
        @BindView(R.id.tvText)
        TextView tvText;

        public DropdownViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
