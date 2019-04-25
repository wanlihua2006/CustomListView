package com.qiku.customlistview;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class myAdapter extends ArrayAdapter {
    private final int imageId;
    private String radiotext;

    public myAdapter(@NonNull Context context, int imageId, @NonNull List<myListView> objects) {
        super(context, imageId, objects);
        this.imageId = imageId;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        myListView mylistView = (myListView) getItem(position);
        View view ;
        if (convertView == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(imageId,parent,false);
            viewHolder.fruitImage = view.findViewById(R.id.headimage);
            viewHolder.fruitName = view.findViewById(R.id.headtext);
            viewHolder.fruitLayout = view.findViewById(R.id.ll_view);
            viewHolder.fruitRadio = view.findViewById(R.id.radioBtn);
            view.setTag(viewHolder);
        }else{
            view =convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.fruitImage.setImageResource(mylistView.getImage());
        viewHolder.fruitName.setText(mylistView.getText());


        viewHolder.fruitRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.radio1:
                        radiotext = "不打";
                        break;
                    case R.id.radio2:
                        radiotext = "打他";
                        break;
                }
            }
        });
        viewHolder.fruitLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"你点击了第"+position+"项"+"你选择"+radiotext,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
        LinearLayout fruitLayout;
        RadioGroup fruitRadio;
    }

  /*  @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView,  @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        myListView myListview = (myListView)getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(imageId,parent,false);
        LinearLayout linearLayout = view.findViewById(R.id.ll_view);
        ImageView headimage =  view.findViewById(R.id.headimage);
        TextView headtext = view.findViewById(R.id.headtext);
        final RadioGroup radio = view.findViewById(R.id.radioBtn);
        final RadioButton radioButton1 =  view.findViewById(R.id.radio1);
        final RadioButton radioButton2 =  view.findViewById(R.id.radio2);
        headimage.setImageResource(myListview.getImage());
        headtext.setText(myListview.getText());

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio1:
                        radiotext = "选我";
                        radioButton1.setId(position);
                        radioButton1.setChecked(true);
                        //radio.check(0);
                        break;
                    case R.id.radio2:
                        radiotext = "不选我";
                        radioButton2.setId(position);
                        radioButton2.setChecked(true);
                        //radio.check(1);
                        break;
                }
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"你点击了第"+ position +"项" + "你选择了" + radiotext, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }*/
}
