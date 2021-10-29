import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;



public class LogMain extends JFrame {

    public static void main(String[] args) {
        LogMain main=new LogMain();
    }

    //这个是定义界面上的所有组件。
     JPanel pUp=new JPanel();
     JPanel pCenter =new JPanel();
     JLabel lblYear=new JLabel("年");
     JLabel lblMonth=new JLabel("月");
     JLabel lblDay=new JLabel("日");
     JComboBox cbxYear=new JComboBox();
     JComboBox cbxMonth=new JComboBox();
     JComboBox cbxDay=new JComboBox();
     JButton btnQuery=new JButton("查询");
     JButton btnSave=new JButton("保存");
     JButton btnDelete=new JButton("删除");
     JTextArea jtaContent=new JTextArea(30,50);
     //用来放组件jtaContent。
     JScrollPane scrollPane;
     String filePath="log\\";
     //在log文件下来存储
     public LogMain(){
         super("我的日记本");
         pUp.add(lblYear);
         pUp.add(cbxYear);
         pUp.add(lblMonth);
         pUp.add(cbxMonth);
         pUp.add(lblDay);
         pUp.add(cbxDay);
         pUp.add(btnDelete);
         pUp.add(btnQuery);
         pUp.add(btnSave);
         scrollPane=new JScrollPane(jtaContent);
         pCenter.add(scrollPane);
         this.add(pUp,BorderLayout.NORTH);
         this.add(pCenter, BorderLayout.CENTER);

         for (int i=2019;i<=2040;i++){
             cbxYear.addItem(String.valueOf(i));
         }

         Calendar calendar=Calendar.getInstance();
         cbxYear.setSelectedItem(String.valueOf(calendar.get(Calendar.YEAR)));
         for (int i=1;i<=12;i++){
             cbxMonth.addItem(String.valueOf(i));
         }
         //这里加一是因为为了和我们月份一样
         cbxMonth.setSelectedItem(String.valueOf(calendar.get(Calendar.MONTH)+1));

         for (int i=1;i<=getDay(calendar.get(Calendar.YEAR),
                 calendar.get(Calendar.MONTH)+1);i++){
             cbxDay.addItem(String.valueOf(i));

         }
         //这个就是让默认当日
         cbxDay.setSelectedItem(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));

         //开始添加事件，各个组件添加事件(全是用匿名内部类来添加）
         //年和月改变后，日的天数要接着改变
         cbxYear.addItemListener(new ItemListener() {
             @Override
             public void itemStateChanged(ItemEvent e) {
                 int year=Integer.parseInt(cbxYear.getSelectedItem().toString());
                 int month=Integer.parseInt(cbxMonth.getSelectedItem().toString());
                 cbxDay.removeAllItems();
                 for (int i=1;i<=getDay(year,month);i++){
                     cbxDay.addItem(String.valueOf(i));
                 }
             }
         });

         cbxMonth.addItemListener(new ItemListener() {
             @Override
             public void itemStateChanged(ItemEvent e) {
                 int year=Integer.parseInt(cbxYear.getSelectedItem().toString());
                 int month=Integer.parseInt(cbxMonth.getSelectedItem().toString());
                 cbxDay.removeAllItems();
                 for (int i=1;i<=getDay(year,month);i++){
                     cbxDay.addItem(String.valueOf(i));
                 }

             }
         });
         btnQuery.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String fileName=filePath+cbxYear.getSelectedItem().toString()
                         +"\\"+cbxMonth.getSelectedItem().toString()
                         +cbxDay.getSelectedItem().toString()+".txt";
                 File path=new File(filePath+cbxYear.getSelectedItem().toString()+"\\");
                 if (path.exists()){
                     try {
                         if (!loadFile(fileName)){
                             JOptionPane.showMessageDialog(LogMain.this,
                                     cbxYear.getSelectedItem().toString()+"年"
                             +cbxMonth.getSelectedItem().toString()+"月"
                             +cbxDay.getSelectedItem().toString()+"号没有日记");
                             jtaContent.setText("");

                         }else {
                             JOptionPane.showMessageDialog(LogMain.this,"恭喜，查询成功");
                         }
                     }catch (IOException e1){
                         System.out.println("读取文件失败："+e1.getMessage());
                         JOptionPane.showMessageDialog(null,"查询失败："+e1.getMessage());

                     }

                 }


             }
         });
         btnDelete.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String fileName=filePath+cbxYear.getSelectedItem().toString()
                         +"\\"+cbxMonth.getSelectedItem().toString()
                         +cbxDay.getSelectedItem().toString()+".txt";
                 File file=new File(fileName);
                 if (file.exists()){
                     if (file.exists())
                         JOptionPane.showMessageDialog(null,"删除成功");
                     else
                         JOptionPane.showConfirmDialog(null,"删除失败");

                 }
                 jtaContent.setText("");

             }
         });

         btnSave.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String fileName=filePath+cbxYear.getSelectedItem().toString()
                         +"\\"+cbxMonth.getSelectedItem().toString()
                         +cbxDay.getSelectedItem().toString()+".txt";
                 File file=new File(fileName);
                 try {
                     saveFile(fileName);
                     JOptionPane.showMessageDialog(null,"保存成功");
                 }catch (IOException e1){
                     System.out.println("文件保存失败"+e1.getMessage());
                     JOptionPane.showMessageDialog(null,"保存失败");
                 }

             }
         });

         this.setSize(800,600);
         this.setVisible(true);
         this.setLocationRelativeTo(null);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


     }



   //这个方法就是来获取一共有多少天，回应前面的getDay
    public int getDay (int year,int month){
         int dnum=0;
         boolean isLeap=false;
         if(year<1000||year>9999||month<1||month>12){
             System.out.println("您输入的月份和年份不合法");
             return 0;

         }
         if ((year%400==0)||(year%4==0&&year%100!=0)){
             isLeap=true;
         }
         switch (month){
             case 1:
             case 3:
             case 5:
             case 7:
             case 8:
             case 10:
             case 12:
                 dnum=31;
                 break;
             case 4:
             case 6:
             case 9:
             case 11:
                 dnum=30;
                 break;
             case 2:
                     if(isLeap){
                         dnum=29;
                     }else dnum=28;
                     break;
         }
         return dnum;
    }

//从fileName中读取数据，显示到对象jtaContent中
    public boolean loadFile(String fileName) throws IOException{
         BufferedReader reader=null;
         File file=new File(fileName);
         if (!file.exists()){
             return false;
             //这里也可以写成 file.createNewFile();

         }
         reader=new BufferedReader(new FileReader(file));
         String content="";
         jtaContent.setText("");
         while ((content=reader.readLine())!=null){
             jtaContent.append(content+"\n");       //JTextArea中\n表示换行

         }
         reader.close();
         return true;

}

//将数据写入道fileName指定的文件中去
    public void saveFile(String fileName) throws IOException{
         BufferedWriter writer=null;
         File file=new File(fileName);
         if (!file.exists()){
             file.createNewFile();
        }
         writer=new BufferedWriter(new FileWriter(file));
         writer.write(jtaContent.getText().replaceAll("\n","\r\n"));
         writer.close();

    }


}

