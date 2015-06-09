package sebi.slowactionapp_improve;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

class Request implements Runnable {
    private EditText input;
    private TextView output;
    private String message;

    public Request(EditText input, String message) {
        this.input = input;
        this.message = message;
    }

    public Request(TextView output, String message) {
        this.output = output;
        this.message = message;
    }

    public void run() {
        Log.d("run_Request", Thread.currentThread().getName());
        if (input != null) {
            input.setText(message);
        } else if (output != null) {
            output.setText(message);
        }
    }
}
