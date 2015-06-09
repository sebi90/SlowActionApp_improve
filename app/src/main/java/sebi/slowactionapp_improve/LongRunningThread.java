package sebi.slowactionapp_improve;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class LongRunningThread extends Thread {

    private long total;
    private EditText input;
    private TextView output;
    private String format;
    private Buffer buffer;

    public LongRunningThread(long total, EditText input, TextView output, String format, Buffer buffer) {
        this.total = total;
        this.input = input;
        this.output = output;
        this.format = format;
        this.buffer = buffer;
    }

    public void run() {

        buffer.getToken();
        doAction();
        buffer.setToken();
    }

    public void doAction()
    {
        Log.d("run_LongRunningThread", Thread.currentThread().getName());
        long rest = total;
        while (rest > 0) {
            long thisTime = Math.min(rest, 1000L);

            try {
                Thread.sleep(thisTime);
            }
            catch (Exception e) {}

            rest -= thisTime;
            Request req = new Request(input, "" + rest);
            input.post(req);
        }
        String message = String.format(format, total);
        Request req = new Request(output, message);
        input.post(req);
    }

}
