package windows;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.List;

import shiqiang.mvptest.R;

/**
 * Created by shiqiang on 2017/2/7.
 */

public class WindowServer extends Service {

    private WindowManager mWindowManager;
    private WindowManager.LayoutParams wmParams;
    private View mWindowView;
    private ImageView mPresent;

    private int mEndY;
    private int mEndX;
    private int mstarty;
    private int mstartX;

    @Override
    public void onCreate() {
        super.onCreate();

        initWindowPrams();

        initView();

        addWindows2();

        initClick();

    }

    private void initClick() {

        mPresent.setOnTouchListener(new View.OnTouchListener() {



            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:

                        mstartX = (int) event.getRawX();
                        mstarty = (int) event.getRawY();

                        break;

                    case MotionEvent.ACTION_MOVE:

                        mEndX = (int) event.getRawX();
                        mEndY = (int) event.getRawY();


                        if(needInf()){

                            wmParams.x = (int) event.getRawX() - mWindowView.getMeasuredWidth() / 2 ;
                            wmParams.y = (int) event.getRawY() - mWindowView.getMeasuredHeight() / 2 ;


                            mWindowManager.updateViewLayout(mWindowView , wmParams);

                            return true ;

                        }



                        break;

                    case MotionEvent.ACTION_UP:

                        if (needInf()){

                            return true;
                        }

                        break;





                }



                return false;
            }
        });




        mPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isAppAtBg(WindowServer.this)){

                    Intent intent = new Intent(WindowServer.this, WindowsMain.class);

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);


                }


            }
        });





    }

    private boolean isAppAtBg(Context context) {

        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        List<ActivityManager.RunningTaskInfo> task = am.getRunningTasks(1);

        if (! task.isEmpty()){

            ComponentName topActivity = task.get(0).topActivity;

            if (! topActivity.getPackageName().equals(context.getPackageName())){
                return true ;
            }

        }

        return false;

    }

    private boolean needInf() {

        if (Math.abs(mstartX - mEndX) > 30 || Math.abs(mstarty - mEndY) > 30){


            return true ;
        }


        return false;





    }

    private void addWindows2() {


        mWindowManager.addView(mWindowView , wmParams);

    }

    private void initView() {
        mWindowView = LayoutInflater.from(getApplication()).inflate(R.layout.windows_server, null);

        mPresent = (ImageView) mWindowView.findViewById(R.id.tv_sever);

    }


    private void initWindowPrams() {

        //获取系统的管理
        mWindowManager = (WindowManager) getApplication().getSystemService(getApplication().WINDOW_SERVICE);

        wmParams = new WindowManager.LayoutParams();

        wmParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        wmParams.format = PixelFormat.TRANSLUCENT ;

        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE ;
        wmParams.gravity = Gravity.LEFT | Gravity.TOP ;
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT ;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT ;




    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }



    @Override
    public IBinder onBind(Intent intent) {


        return null;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mWindowView != null){

            mWindowManager.removeView(mWindowView);

        }
    }
}
