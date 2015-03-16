package com.vnfapps.hide.talktostranger.controllers;


import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

/**
 * @author hide
 * @since 14/03/2015.
 */
public class ChatController {
    public static final String TAG = ChatController.class.getName();
    private static final String HOST = "192.168.1.11";
    private static final String PORT = "3000";
    private static final String PROTOCOL = "http";
    private static final String NAMESPACE = "chat";

    private static ChatController instance;
    private Socket socket;
    /**
     *
     */
    private ChatController() {
        try {
            socket = IO.socket(PROTOCOL+"://"+HOST+":"+PORT+"/"+NAMESPACE);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private ChatController(Socket socket) {
        this.socket = socket;
    }

    private ChatController(IO.Options opts) {
        try {
            socket = IO.socket(PROTOCOL+"://"+HOST+":"+PORT, opts);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static synchronized void init(){
        instance = new ChatController();
    }
    public static ChatController getInstance(){
        return instance;
    }
    public void connect(){
        Log.i(TAG+".connect", "start");
        if(socket!=null){
            socket.connect();
            //trigger on connect to server
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    Log.i(TAG+".connect", "on connection");
                    ViewController.getInstance().showChatScreen();
                }
            });
            //trigger on disconnect to server
            socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {

                }
            });
            //trigger on err to connect server
            socket.on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    Log.i(TAG+".connect", Socket.EVENT_CONNECT_ERROR);
                }
            });
            //trigger on timeout
            socket.on(Socket.EVENT_CONNECT_TIMEOUT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {

                }
            });
            //trigger on received a message
            socket.on(Socket.EVENT_MESSAGE, new Emitter.Listener() {
                @Override
                public void call(Object... args) {

                }
            });
        }
    }

    public void disconnect(){
        if(socket!=null){
            socket.disconnect();
        }
    }

    private interface Listener{
        public final String ADD_TO_WAITING_LIST = "user.addToWaitingList";
    }
}

