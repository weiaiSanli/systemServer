package shiqiang.mvptest.observe;

/**
 * Created by shiqiang on 2016/12/21.
 */

public interface Subject {

    void addObserve(Observer observer);

    void delete(Observer observer);


    void notifyObservers();


    void opration();




}
