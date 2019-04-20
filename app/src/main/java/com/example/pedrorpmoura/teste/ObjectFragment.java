package com.example.pedrorpmoura.teste;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ObjectFragment extends DialogFragment {

    private MObject object;

    public ObjectFragment() {

    }

    public void setObject(MObject object) {
        this.object = object;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root_view = inflater.inflate(R.layout.object_layout,
                container, false);

        ImageView image_view = new ImageView(getActivity());
        image_view.setImageResource(this.object.getPic());
        image_view.setAdjustViewBounds(true);
        image_view.setScaleType(ImageView.ScaleType.CENTER_CROP);

        TextView name_view = new TextView(getActivity());
        String name_aux = "<b>" + this.object.getName() + "</b>";
        setTextViewParams(name_view, name_aux);

        TextView dating_view = new TextView(getActivity());
        String dating_aux = "<b>" + "Datação: " + "</b>"
                + this.object.getDating();
        setTextViewParams(dating_view, dating_aux);

        TextView material_view = new TextView(getActivity());
        String material_aux = "<b>" + "Material: " + "</b>"
                + this.object.getMaterial();
        setTextViewParams(material_view, material_aux);

        TextView dimension_view = new TextView(getActivity());
        String dimension_aux = "<b>" + "Dimensão: " + "</b>"
                + this.object.getDimension();
        setTextViewParams(dimension_view, dimension_aux);

        TextView description_view = new TextView(getActivity());
        String description_aux = "<b>" + "Descrição: " + "</b>"
                + this.object.getDescription();
        setTextViewParams(description_view, description_aux);

        LinearLayout my_layout = root_view.findViewById(R.id.object_layout);
        my_layout.addView(image_view);
        my_layout.addView(name_view);
        my_layout.addView(dating_view);
        my_layout.addView(material_view);
        my_layout.addView(dimension_view);
        my_layout.addView(description_view);

        Button close_button = (Button) root_view.findViewById(R.id.close_button);
        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return root_view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }

    @Override
    public void onResume() {
        super.onResume();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.height = height - 200;
        params.width = width - 200;

        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
    }


    public void setTextViewParams(TextView text_view, String aux) {

        text_view.setGravity(Gravity.CENTER);
        text_view.setText(Html.fromHtml(aux));
        text_view.setTextSize(20);
        text_view.setBackgroundResource(android.R.drawable.editbox_background);

    }
}
