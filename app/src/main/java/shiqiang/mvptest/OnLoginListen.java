package shiqiang.mvptest;

/**
 *
 * 数据的传递,让activity继承并把数据传递给userBiz 进行联网操作的请求并将数据返回给Activity
 * Created by shiqiang on 2016/10/18.
 */
public interface OnLoginListen {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void loginSuccess(String successLog);

    void loginFailed(String faliedLog);

}
