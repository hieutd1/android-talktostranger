package com.vnfapps.hide.talktostranger.views.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.vnfapps.hide.talktostranger.models.Message;

import java.util.List;

/**
 * @author hide
 * @since 15/03/2015.
 */
public class MessageAdapter extends BaseAdapter{
    private Context mContext;
    private List<Message> messages;

    public MessageAdapter() {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
