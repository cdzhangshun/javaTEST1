package ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//利用窗口类本身来实现，将自己本身作为监听器

public class Add2 extends JFrame implements ActionListener {
    private JTextField txtNumber1=new JTextField(15);
    private JLabel lalFuHao=new JLabel("+");
    private JTextField txtNumber2=new JTextField(15);
    private JButton btnEqual=new JButton("=");
    private JTextField txtSum=new JTextField(15);
    public Add2(){
        setTitle("这是一个两个数相加的程序");
        initialize();
    }
    private void initialize(){
        setLayout(new FlowLayout());    //设置窗口的布局为FlowLayout
        add(txtNumber1);
        add(lalFuHao);
        add(txtNumber2);
        add(btnEqual);
        add(txtSum);

        //这里利用窗口来实现ActionListener接口
        btnEqual.addActionListener(this);    //这里和Add3不一样，这里是this，但是Add3用的是匿名类
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    //这里来实现ActionListener的接口，必须实现

    public void actionPerformed(ActionEvent e){
        //通过按了等号开始触发事件
        if (e.getSource()==btnEqual){
            if(txtNumber1.getText().trim().equals("") ||txtNumber2.getText().trim().equals("")){
                JOptionPane.showConfirmDialog(Add2.this,"加数和被加数都不能为空",
                        "提示信息",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            double a,b,sum;
            try {
                a=Double.valueOf(txtNumber1.getText());
                b=Double.valueOf(txtNumber2.getText());
                sum=a+b;
                txtSum.setText(String.valueOf(sum));

            }catch (Exception e1){
                JOptionPane.showConfirmDialog(Add2.this,"加数和被加数都不能为空",
                        "提示信息",JOptionPane.INFORMATION_MESSAGE);
                return;

            }


        }


    }


    public static void main(String[] args) {
        Add3 add3=new Add3();
        add3.setSize(600,200);
        add3.setVisible(true);
        add3.setLocationRelativeTo(null);      //这个就是为了能让代码可以居中显示
    }


}
