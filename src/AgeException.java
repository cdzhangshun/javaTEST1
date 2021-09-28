public class AgeException extends Exception{

    public AgeException() {
        super("年纪超出范围了哈，嘿嘿嘿");
    }

    public AgeException(String message) {

        super(message);
    }
}
class People{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if (age<0||age>200){
            throw new AgeException();
        }
        this.age=age;
    }
    public static void main(String[] args) {
        People p=new People();
        try {
            p.setAge(250);

        }
        catch (AgeException e){
            System.out.println("给age的赋值出现异常，请重新赋值："+e.getMessage());
        }
    }
}

