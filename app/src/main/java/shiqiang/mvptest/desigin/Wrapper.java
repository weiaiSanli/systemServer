package shiqiang.mvptest.desigin;

/**
 * Created by shiqiang on 2016/12/19.
 */

public class Wrapper implements ClassInfi {


    public  SourceInfi sout;

    public Wrapper(SourceInfi sout){

       super();
       this.sout = sout ;

    }




    @Override
    public String method1(String name) {
        return sout.method1(name);
    }

    @Override
    public void method2(String name2) {

        System.out.println("heihie2 " + name2);

    }
}
