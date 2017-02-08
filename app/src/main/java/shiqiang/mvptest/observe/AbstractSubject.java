package shiqiang.mvptest.observe;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by shiqiang on 2016/12/21.
 */

public class AbstractSubject implements Subject {


    private Vector<Observer> vector = new Vector<>();



    @Override
    public void addObserve(Observer observer) {

        vector.add(observer);
    }

    @Override
    public void delete(Observer observer) {

        vector.remove(observer);

    }

    @Override
    public void notifyObservers() {

        Enumeration<Observer> elements = vector.elements();

        while (elements.hasMoreElements() ){

            elements.nextElement().update();

        }



    }

    @Override
    public void opration() {

    }


}
