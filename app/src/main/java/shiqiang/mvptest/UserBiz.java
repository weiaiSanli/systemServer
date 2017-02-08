package shiqiang.mvptest;

/**
 *
 * 做联网的请求
 * Created by shiqiang on 2016/10/18.
 */
public class UserBiz implements IUserBiz {

   private OnLoginListen onLoginListen;

    public UserBiz(OnLoginListen onLoginListen) {

        this.onLoginListen = onLoginListen;




    }

    @Override
    public void login() {


        //拿到输入的账号名跟密码
        String userName = onLoginListen.getUserName();
        String password = onLoginListen.getPassword();

        System.out.println(userName + " ---" + password);

        //检验值  比如 账号: shi 密码 123

        if (userName.equals("shi") && password.equals("123")){

            //把联网成功以后的数据返回给Activity让他更新控件
            onLoginListen.loginSuccess("我成功了!少年");

        }else{

            onLoginListen.loginFailed("呜呜,我失败了~");


        }





    }

    @Override
    public void clean() {

        onLoginListen.clearUserName();
        onLoginListen.clearPassword();




    }
}