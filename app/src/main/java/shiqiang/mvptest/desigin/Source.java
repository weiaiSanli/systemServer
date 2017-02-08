package shiqiang.mvptest.desigin;

/**
 * Created by shiqiang on 2016/12/19.
 */

public class Source implements SourceInfi {
    @Override
    public String method1(String name) {

        System.out.println("woshi 1" + name);

        return name + "hehe ";

    }
}
