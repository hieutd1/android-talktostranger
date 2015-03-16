package com.vnfapps.hide.talktostranger.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.vnfapps.hide.talktostranger.R;
import com.vnfapps.hide.talktostranger.controllers.ChatController;

/**
 * @author hide
 * @since 15/03/2015.
 */
public class JoinFragment extends Fragment{
    public static final String TAG = JoinFragment.class.getName();
    private Button joinBtn;
    private ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.join_screen, container, false);
        imageView = (ImageView) root.findViewById(R.id.imageView);
        joinBtn = (Button) root.findViewById(R.id.button);
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG+".onClick", "joinBtn.onclick");
                ChatController.getInstance().connect();
            }
        });

        return root;
    }
}
