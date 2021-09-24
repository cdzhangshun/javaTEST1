package Business;

public class TestReadSaveDate {
    public static void main(String[] args) {
        //BusinessA需要往文本文件中保存数据
        BusinessA businessA=new BusinessA(new ReadSavaTextFile());
        businessA.saveDate("保存到文本文件中，记得了哈");

        BusinessB businessB=new BusinessB(new ReadSaveWordFile());
        businessB.saveDate("保存到word文件中了哈");

        //只要传递不同的实现类对象，就能保存到不同的数据库中

    }
}
