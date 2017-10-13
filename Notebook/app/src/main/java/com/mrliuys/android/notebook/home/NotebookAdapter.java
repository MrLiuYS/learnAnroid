package com.mrliuys.android.notebook.home;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mrliuys.android.notebook.R;

import java.util.List;

/**
 * Created by LiuYongSheng on 2017/10/13.
 */

public class NotebookAdapter extends ArrayAdapter<NotebookModel> {

    private int resourceId;

    public NotebookAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<NotebookModel> objects) {
        super(context, resource, textViewResourceId, objects);
        resourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        NotebookModel model = getItem(position);

        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.titleLabel = view.findViewById(R.id.main_cell_title);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.titleLabel.setText(model.getTitle());

        return view;
    }


    class ViewHolder {

        TextView titleLabel;

    }
}
