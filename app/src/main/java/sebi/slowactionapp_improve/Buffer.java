package sebi.slowactionapp_improve;

import android.util.Log;

public class Buffer {

    private boolean ready;

    public Buffer() {
        ready = true;
    }

    public synchronized void getToken() {
        Log.d("getToken", ready + "");
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ready = false;
        notifyAll();
    }

    public synchronized void setToken() {
        ready = true;
        notify();
    }
}
