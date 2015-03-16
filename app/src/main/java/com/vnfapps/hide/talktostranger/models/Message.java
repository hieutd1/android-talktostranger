package com.vnfapps.hide.talktostranger.models;


import java.sql.Time;

/**
 * @author hide
 * @since 15/03/2015.
 */
public class Message {
    public static final String TAG = Message.class.getName();
    public MessageType messageType;
    //public TimeZone
    public String content;

    public Message() {
        messageType = MessageType.SENT;

        content = "";
    }

    public Message(final MessageType messageType, final Time time, final String content) {
        this.messageType = messageType;
        //this.time = time;
        this.content = content;
    }

    public Message(final Message message){
        //time = message.time;
        content = message.content;
        messageType = message.messageType;
    }
}
