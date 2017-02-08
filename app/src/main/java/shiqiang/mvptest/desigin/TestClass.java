package shiqiang.mvptest.desigin;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by shiqiang on 2016/12/19.
 */

public class TestClass extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ClassInfi so = new Adapter();
        String shiqiang = so.method1("shiqiang");

        so.method2(shiqiang);



        SourceInfi source = new Source();
        Wrapper target = new Wrapper(source);
        String xiao = target.method1("小迪");
        target.method2(xiao + "mei");



        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();

        source1.method1("萌萌");
        source1.method2("meng");
        source2.method1("mengmeng2");
        source2.method2("mengmeng 3");



    }
}
