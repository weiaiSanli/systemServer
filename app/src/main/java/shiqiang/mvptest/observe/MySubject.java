package shiqiang.mvptest.observe;

/**
 * Created by shiqiang on 2016/12/21.
 */

public class MySubject extends AbstractSubject {


    @Override
    public void opration() {


        System.out.println("我是MySubject");

        notifyObservers();


    }
}
