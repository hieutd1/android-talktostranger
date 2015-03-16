package com.vnfapps.hide.talktostranger.controllers;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.vnfapps.hide.talktostranger.R;
import com.vnfapps.hide.talktostranger.views.fragments.ChatFragment;
import com.vnfapps.hide.talktostranger.views.fragments.JoinFragment;

import java.util.HashMap;

/**
 * @author hide
 * @since 15/03/2015.
 */
public class ViewController {
    public static final String TAG = ViewController.class.getName();
    private static final int FRAGMENT_CONTAINER = R.id.container;

    private static ViewController instance;
    private HashMap<Integer, View> screens;
    private Context context;
    private FragmentManager fragmentManager;
    private Fragment currentFragment;

    private ViewController(Context context, FragmentManager fragmentManager){
        screens = new HashMap<>();
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    public synchronized static void init(Context context, FragmentManager fragmentManager){
        instance = new ViewController(context, fragmentManager);
        instance.fragmentsInit();
        instance.showJoinScreen();
    }

    public static ViewController getInstance(){
        return instance;
    }
    /*
     ************************************************************
     * Fragment manage functions
     ************************************************************
     */
    public void fragmentsInit(){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        currentFragment = new JoinFragment();
        fragmentTransaction.add(FRAGMENT_CONTAINER, currentFragment, JoinFragment.TAG).hide(currentFragment);

        currentFragment = new ChatFragment();
        fragmentTransaction.add(FRAGMENT_CONTAINER, currentFragment, ChatFragment.TAG).hide(currentFragment);

        fragmentTransaction.commit();

        currentFragment = null;
        if(fragmentManager.executePendingTransactions()) {
            Log.i(TAG + ".fragmentInit", Integer.toString(fragmentManager.getFragments().size()));
        }

    }

    private void showFragment(String fragmentTag){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(currentFragment!=null){
            Log.i(TAG + ".showFragment", currentFragment.toString());
            fragmentTransaction.hide(currentFragment);
        }else {
            Log.i(TAG + ".showFragment", "currentFragment null");
        }
        currentFragment = (Fragment)fragmentManager.findFragmentByTag(fragmentTag);
        fragmentTransaction.show(currentFragment);
        fragmentTransaction.addToBackStack(fragmentTag).commit();
    }

    public void showJoinScreen(){
        showFragment(JoinFragment.TAG);
    }
    public void showChatScreen(){
        showFragment(ChatFragment.TAG);
    }

    public void onBackPressed(){
        FragmentManager.BackStackEntry backEntry = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1);
        Log.d(TAG+".onBackPressed", backEntry.getName());
        currentFragment = (Fragment)fragmentManager.findFragmentByTag(backEntry.getName());
        try {
            //setData(currentFragment.getData());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
