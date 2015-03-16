package com.vnfapps.hide.talktostranger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;

import com.vnfapps.hide.talktostranger.controllers.ChatController;
import com.vnfapps.hide.talktostranger.controllers.ViewController;

/**
 * @author hide
 * @since 14/03/2015.
 */
public class Activity extends FragmentActivity{
    public static final String TAG = Activity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_layout, null, false);
        setContentView(view);
        ViewController.init(getApplicationContext(), getSupportFragmentManager());
        ChatController.init();
    }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        /*if(!BaseViewHolder.getInstance().onBackPressed()) {
            super.onBackPressed();
        }*/
        FragmentManager fragmentManager = getSupportFragmentManager();
        /*FragmentManager.BackStackEntry backEntry=fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount()-1);
        Logger.i(TAG+"onBackPressed", backEntry.toString());*/
        //Logger.i(TAG+"onBackPressed", Integer.toString(BaseViewHolder.getInstance().onBackPressed()));
        fragmentManager.popBackStack();
        fragmentManager.executePendingTransactions();
        if(fragmentManager.getBackStackEntryCount()==0){
            super.onBackPressed();
        }else {
            ViewController.getInstance().onBackPressed();
        }
    }
}
