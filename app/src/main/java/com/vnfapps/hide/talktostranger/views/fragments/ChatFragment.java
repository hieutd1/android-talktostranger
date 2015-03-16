package com.vnfapps.hide.talktostranger.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.vnfapps.hide.talktostranger.R;
import com.vnfapps.hide.talktostranger.controllers.ChatController;

/**
 * @author hide
 * @since 16/03/2015.
 */
public class ChatFragment extends Fragment {
    public static final String TAG = ChatFragment.class.getName();
    private Button btnBack;
    private LinearLayout messageContainer;
    private EditText message;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.chat_screen, container, false);
        btnBack = (Button) root.findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        messageContainer = (LinearLayout) root.findViewById(R.id.messages_container);
        message = (EditText) root.findViewById(R.id.message);
        return root;
    }

    public void onBackPressed(){
        ChatController.getInstance().disconnect();
    }
}
