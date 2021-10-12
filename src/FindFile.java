import java.io.File;
import java.util.Date;
public class FindFile {
    public static void main(String[] args) {
        String path ="D:\\学习\\.idea";

        File file = new File(path);
        File[] files = file.listFiles();
        Find(files);

    }
    public static   void Find(File a[]){
        int dirNum=0;
        int fileNum=0;
        File file=new File("D:\\Git--Space");
        if (!file.exists()){
            try {
                file.createNewFile();

            }catch (Exception e){
                System.out.println("出现异常了，有问题啊啊啊");
            }
        }
        System.out.println("文件是否存在："+file.exists());
        System.out.println("文件？"+file.isFile()+"\n"+"目录？"+file.isDirectory());
        System.out.println("文件名："+file.getName()+"\n"+"路径名："+file.getPath()+"\n"
                             +"绝对路径名字字符串：" +file.getAbsolutePath());
        File directory=new File("D:\\学习\\.idea");
        System.out.println(directory.mkdir());
        File dir=new File("D:\\学习");
        String str[]=dir.list();
        for (int i=0;i<str.length;i++){
            System.out.println(str[i]);

        }
        File[] fs=dir.listFiles();
        for (int i=0;i<fs.length;i++ ){
            System.out.println(fs[i]);
            System.out.println(fs[i].getName());
            //******下面这句是一个匿名函数，来获取文件时间，这个需要注意
            System.out.println(new Date(fs[i].lastModified())+"\t");
            /**
             * 这里还是有些不清楚，感觉遍历了好多次，不知道什么原因，调试不出来
             */
            if (fs[i].isDirectory()){
                Find(fs[i].listFiles());
                dirNum++;
                System.out.println("<DIR>\t");

            }else {
                fileNum++;
                System.out.println(fs[i].length()+"\t");
            }

        }

        file.delete();
    }

}
