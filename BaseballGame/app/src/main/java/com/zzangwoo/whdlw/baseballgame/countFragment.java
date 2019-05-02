package com.zzangwoo.whdlw.baseballgame;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class countFragment extends Fragment {

    int count;

    public countFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
           count = savedInstanceState.getInt("count");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.count_fragment, container, false);

        Drawable alpha = (Drawable) v.findViewById(R.id.countBackground).getBackground();
        alpha.setAlpha(50);

        TextView count_text = (TextView) v.findViewById(R.id.count_count);
        count_text.setText(Integer.toString(count));

        return v;
    }
}

//////////////////////////////////////// 랭킹에서 횟수 순위에 대한 fragment //////////////////////////////////////////////////