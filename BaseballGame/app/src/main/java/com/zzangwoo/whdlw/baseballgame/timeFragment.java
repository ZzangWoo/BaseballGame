package com.zzangwoo.whdlw.baseballgame;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class timeFragment extends Fragment {

    public timeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.time_fragment, container, false);
    }
}

//////////////////////////////////////// 랭킹에서 시간 순위에 대한 fragment //////////////////////////////////////////////////