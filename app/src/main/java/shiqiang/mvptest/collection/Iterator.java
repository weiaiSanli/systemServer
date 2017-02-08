package shiqiang.mvptest.collection;

/**
 * Created by shiqiang on 2016/12/22.
 */

public interface Iterator {

    //前移
    Object previous();

    //后移
    Object next();
    boolean hasNext();

    //取得第一个元素
    Object first();



}
