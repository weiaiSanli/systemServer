package windows;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import shiqiang.mvptest.R;

/**
 * Created by shiqiang on 2017/2/7.
 */

public class WindowsMain extends Activity {


    private WindowManager mWindowManager;
    private WindowManager.LayoutParams wmParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_windows);


        Button start = (Button) findViewById(R.id.bt_star);
        Button stop = (Button) findViewById(R.id.bt_stop);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //开启服务
                Intent intent = new Intent(WindowsMain.this,WindowServer.class);
                startService(intent);


                }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(WindowsMain.this,WindowServer.class);
                stopService(intent2);


            }
        });


    }

}
