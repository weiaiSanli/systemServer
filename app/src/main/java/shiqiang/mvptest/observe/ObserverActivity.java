package shiqiang.mvptest.observe;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by shiqiang on 2016/12/21.
 */

public class ObserverActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MySubject mySubject = new MySubject();


        Observer2 observer2 = new Observer2();
        mySubject.addObserve(new Observer1());
        mySubject.addObserve(observer2);


        mySubject.opration();

        mySubject.delete(observer2);

        mySubject.opration();



    }
}
