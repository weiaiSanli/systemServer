package shiqiang.mvptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import shiqiang.mvptest.collection.Iterator;
import shiqiang.mvptest.collection.MyCollection;

public class MainActivity extends AppCompatActivity implements OnLoginListen{

    private EditText etUser;
    private EditText etPwd;
    private Button btLog;
    private Button btClear;
    private IUserBiz mUserBiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.et_user);
        etPwd = (EditText) findViewById(R.id.et_pwd);



        btLog = (Button) findViewById(R.id.bt_log);
        btClear = (Button) findViewById(R.id.bt_clear);


        MyCollection myCollection = new MyCollection();

        Iterator iterator = myCollection.iterator();

//        System.out.println(iterator.first().toString() + "nimei");

        while (iterator.hasNext()){

            System.out.println(iterator.next() + "我是:");

        }

        //调取网络接口实现类的实例,并把activity出传递进去就可以拿到数据以及传递值了  this 一定要注意
        mUserBiz = new UserBiz(this);


        btLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //点击的时候调取login操作
                mUserBiz.login();


            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //清理输入
                mUserBiz.clean();


            }
        });


        System.out.println("我经历啊了");


    }

    @Override
    public String getUserName() {

        //讲输入的值传递给P层联网更新数据
        return etUser.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPwd.getText().toString().trim();
    }

    @Override
    public void clearUserName() {

        etUser.setText("");

    }

    @Override
    public void clearPassword() {

        etPwd.setText("");
    }

    @Override
    public void loginSuccess(String successLog) {

        //打印传递过来的值
        Toast.makeText(this,successLog,Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFailed(String faliedLog) {
        //打印传递过来的值
        Toast.makeText(this,faliedLog,Toast.LENGTH_LONG).show();

    }


}
