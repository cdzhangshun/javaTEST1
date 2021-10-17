import java.io.*;
public class CopyFile {
    public static void main(String[] args) {
        testcopyfile();
    }
    public static  void testcopyfile(){
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;
    try {

        bufferedReader = new BufferedReader(new FileReader(new File("D:\\学习\\node.txt")));
        bufferedWriter = new BufferedWriter(new FileWriter(new File("D:\\学习\\node1.txt")));

        String data;
        while ((data = bufferedReader.readLine()) != null) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        }


    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (bufferedWriter != null) {

            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bufferedReader != null) {

            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
}
