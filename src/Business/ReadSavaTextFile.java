package Business;

public class ReadSavaTextFile implements IReadSaveDate{
    @Override
    public void saveDate(String date) {
        System.out.println("将数据保存到文本文件中了，哈哈哈哈");

    }
    public  String getDate(){
        System.out.println("从文本文件中读取了数据，哈哈哈哈");
        return null;
    }

}
 class ReadSaveWordFile implements IReadSaveDate{

    @Override
    public void saveDate(String date) {
        System.out.println("将数据保存到word文档中去了");
    }

    @Override
    public String getDate() {
        System.out.println("从word文档中读取到了数据");
        return null;
    }
}
