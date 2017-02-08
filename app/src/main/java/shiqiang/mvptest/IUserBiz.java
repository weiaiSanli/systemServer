package shiqiang.mvptest;

/**
 * 需要做的联网登录的请求接口,这个最好第一步写,想好你的需求,可以是一个网络请求,后期再加入其它的
 *
 * 创建一个实体类实现它
 * Created by shiqiang on 2016/10/18.
 */
public interface IUserBiz {

     void login();

     void clean();


}
