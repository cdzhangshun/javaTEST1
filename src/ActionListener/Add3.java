package ActionListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//这个是采用匿名内部类实现监听器接口的方法来实现。
public class Add3 extends JFrame {
    private JTextField txtNumber1=new JTextField(15);
    private JLabel lalFuHao=new JLabel("+");
    private JTextField txtNumber2=new JTextField(15);
    private JButton btnEqual=new JButton("=");
    private JTextField txtSum=new JTextField(15);
    public Add3(){
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


        //用匿名内部类实现Actionlistener接口，注册监听器
        btnEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtNumber1.getText().trim().equals("") ||txtNumber2.getText().trim().equals("")){
                    JOptionPane.showConfirmDialog(Add3.this,"加数和被加数都不能为空",
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
                    JOptionPane.showConfirmDialog(Add3.this,"加数和被加数都不能为空",
                            "提示信息",JOptionPane.INFORMATION_MESSAGE);
                    return;

                }


            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Add3 add3=new Add3();
        add3.setSize(600,200);
        add3.setVisible(true);
        add3.setLocationRelativeTo(null);      //这个就是为了能让代码可以居中显示

    }


}
