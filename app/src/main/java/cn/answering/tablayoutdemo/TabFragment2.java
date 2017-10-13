package cn.answering.tablayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by HP on 2017/10/13.
 */

public class TabFragment2 extends Fragment {

    private TextView textView;

    public static TabFragment2 newInstance(int index){
        Bundle bundle = new Bundle();
        bundle.putInt("index",'A' + index);
        TabFragment2 fragment = new TabFragment2();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tav_layout2,null);
        textView = (TextView) view.findViewById(R.id.text_view_2);
        textView.setText(String.valueOf((char) getArguments().getInt("index")));
        return view;
    }
}
