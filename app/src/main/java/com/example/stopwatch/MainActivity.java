package com.example.stopwatch;
import android.app.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {
private  int seconds=0;
private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }
    public void onclickstart(View view){
    running=true;

    }
    public void onclickstop(View view){
        running=false;

    }
    public void onclickreset(View view){
        running=false;
         seconds=0;
     }

private  void runTimer()
{final TextView timeview=(TextView)findViewById(R.id.timeview);
final Handler handler= new Handler();
handler.post(new Runnable() {
    @Override
    public void run() {
        int hours=seconds/3600;
        int minutes=(seconds%3600)/60;
        int secs=seconds%60;

        String time=String.format("%d:%02d:%02d",hours,minutes,secs);
        timeview.setText(time);
        if(running)
        {
            seconds++;
        }
handler.postDelayed(this,1000);
    }
});



}


}
