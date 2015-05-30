package sebi.slowactionapp_improve;

import android.util.Log;

/**
 * Created by Sebi on 30.05.15.
 */
public class Buffer {

    private boolean ready;

    public Buffer()
    {
        ready = true;
    }

    public synchronized void getToken()
    {
        Log.i("getToken", ready +"");
        while (!ready)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ready = false;
        notify();
    }

    public synchronized void setToken()
    {
        ready = true;
        notify();
    }
}
