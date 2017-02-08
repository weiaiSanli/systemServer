package shiqiang.mvptest.collection;

/**
 * Created by shiqiang on 2016/12/22.
 */

public class MyIterator implements Iterator {

    private MyCollection myCollection;

    private int pos = -1;

    public MyIterator(MyCollection myCollection) {

        this.myCollection = myCollection;




    }

    @Override
    public Object previous() {

        if (pos > 0){

            pos -- ;
        }

        return myCollection.get(pos);
    }

    @Override
    public Object next() {

        if (pos < myCollection.size() - 1){

            pos ++ ;

        }

        return myCollection.get(pos);
    }

    @Override
    public boolean hasNext() {

        if (pos < myCollection.size() - 1){

            return true ;

        }else{
            return false ;
        }

    }

    @Override
    public Object first() {

        pos = 0 ;

        return myCollection.get(pos);
    }
}
