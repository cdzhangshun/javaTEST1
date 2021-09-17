import Accout.accout;
public class Bank {
    public static void main(String[] args) {
        accout zhangsan = new accout("1", "张三", 2000);
        accout wangwu = new accout("2", "王五", 1000);
        zhangsan.deposite(200);
        wangwu.withdraw(300);
        zhangsan.changeMoney(wangwu, 500);
        System.out.println("张三的余额是；" + zhangsan.getBalance());
        System.out.println("王五的余额是；" + wangwu.getBalance());
        //利用例外一个对象，在getBalance中利用静态变量，得到银行账户总余额，利用static。。。。。
        accout all=new accout();
        System.out.println(all.getAllmoney());

    }
}