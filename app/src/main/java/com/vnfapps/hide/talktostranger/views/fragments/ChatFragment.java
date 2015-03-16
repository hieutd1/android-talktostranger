package com.vnfapps.hide.talktostranger.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vnfapps.hide.talktostranger.R;

/**
 * @author hide
 * @since 16/03/2015.
 */
public class ChatFragment extends Fragment {
    public static final String TAG = ChatFragment.class.getName();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.chat_screen, container, false);

        return root;
    }
}
