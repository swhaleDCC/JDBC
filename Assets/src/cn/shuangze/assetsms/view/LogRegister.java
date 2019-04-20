package cn.shuangze.assetsms.view;
import cn.shuangze.assetsms.dao.impl.UsersDaoJDBCImpl;
import cn.shuangze.assetsms.entity.Users;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//注册界面
public class LogRegister extends JFrame implements ActionListener, ListSelectionListener {
    UsersDaoJDBCImpl userDao;
    JLabel username=new JLabel();
    JLabel password=new JLabel();
    JLabel phone=new JLabel();
    JLabel username2=new JLabel();
    JLabel password2=new JLabel();
    JLabel phone2=new JLabel();
    JLabel email=new JLabel();
    JLabel pass=new JLabel();
    JLabel email2=new JLabel();
    JLabel pass2=new JLabel();
    JTextField jTextField1 = new JTextField(20);
    JTextField jTextField2 = new JTextField(20);
    JTextField jTextField3 = new JTextField(20);
    JTextField jTextField4 = new JTextField(20);
    JTextField jTextField5 = new JTextField(20);
    JButton reg = new JButton(new ImageIcon("images\\preview.png"));
    JButton clear = new JButton(new ImageIcon("images\\delete.png"));
    JPanel onePanel = new JPanel();
    JPanel onePanel1 = new JPanel();
    JPanel onePanel2 = new JPanel();
    JPanel onePanel3 = new JPanel();
    JPanel twoPanel = new JPanel();
    JPanel twoPanel1 = new JPanel();
    JPanel twoPanel2 = new JPanel();
    JPanel twoPanel3 = new JPanel();
    JPanel threePanel = new JPanel();
    Container contentPane;
    Dimension faceSize = new Dimension(500,500);

    public LogRegister(){
        try{
            init();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "资产信息增加错误", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void init() throws Exception{
        userDao=new UsersDaoJDBCImpl();
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        onePanel.setLayout(new BorderLayout());
        twoPanel.setLayout(new BorderLayout());
        this.setSize(faceSize);
        this.setTitle("注册");
        this.setResizable(true);
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 400) / 2,
                (screenSize.height - 300) / 2 + 45);
        
        username.setText("*用户名");
        username.setFont(new Font("Dialog", 0, 12));
        username2.setText("必填选项");
        username2.setFont(new Font("Dialog", 0, 12));
        onePanel1.add(username);
        onePanel1.add(jTextField1);
        onePanel1.add(username2);
        
        password.setText("*密    码");
        password.setFont(new Font("Dialog", 0, 12));
        onePanel2.add(password);
        password2.setText("必填选项");
        password2.setFont(new Font("Dialog", 0, 12)); 
        onePanel2.add(jTextField2);
        onePanel2.add(password2);
        
        phone.setText("*手机号");
        phone.setFont(new Font("Dialog", 0, 12));
        onePanel3.add(phone);
        phone2.setText("必填选项");
        phone2.setFont(new Font("Dialog", 0, 12));
        onePanel3.add(jTextField3);
        onePanel3.add(phone2);
        
        onePanel.add(onePanel1,BorderLayout.NORTH);
        onePanel.add(onePanel2,BorderLayout.CENTER);
        onePanel.add(onePanel3,BorderLayout.SOUTH);
        
        contentPane.add(onePanel,BorderLayout.NORTH);
        
        email.setText("邮    箱");
        email.setFont(new Font("Dialog", 0, 12));
        twoPanel1.add(email);
        twoPanel1.add(jTextField4);
        email2.setText("             ");
        email2.setFont(new Font("Dialog", 0, 12));
        twoPanel1.add(email2);
        
        reg.setText("注册");
        reg.setFont(new Font("Dialog", 0, 12));
        twoPanel3.add(reg);
        reg.addActionListener(this);
        reg.setEnabled(true); 
        
        clear.setText("重置");
        clear.setFont(new Font("Dialog", 0, 12));
        twoPanel3.add(clear);
        clear.addActionListener(this);
        clear.setEnabled(true);
        
        twoPanel.add(twoPanel1,BorderLayout.NORTH);
        twoPanel.add(twoPanel2,BorderLayout.CENTER);
        twoPanel.add(twoPanel3,BorderLayout.SOUTH);
        contentPane.add(twoPanel,BorderLayout.CENTER);       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        List l;
        if(obj==reg){
            try {
                if(jTextField1.getText().trim().equals("")||jTextField2.getText().trim().equals("")||jTextField3.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "用户名、密码、手机号必填！", "注册", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    l=userDao.findAllName();
                    if(l.contains(jTextField1.getText())){
                        jTextField1.setText(null);
                        jTextField2.setText(null);
                        jTextField3.setText(null);
                        jTextField4.setText(null);
                        jTextField5.setText(null);
                        JOptionPane.showMessageDialog(null, "用户名已存在！", "注册", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        userDao.add(new Users(jTextField1.getText(),jTextField2.getText(), jTextField3.getText(),jTextField4.getText()));
                        JOptionPane.showMessageDialog(null, "注册成功！", "注册", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "资产信息增加错误", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
        }else if(obj==clear){
            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextField3.setText(null);
            jTextField4.setText(null);
            jTextField5.setText(null);
            
            jTextField1.setEditable(true);
            jTextField2.setEditable(true);
            jTextField3.setEditable(true);
            jTextField4.setEditable(true);
            jTextField5.setEditable(true);
            
            reg.setEnabled(true);
            clear.setEnabled(true);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JOptionPane.showMessageDialog(null, "错误操作！", "", JOptionPane.INFORMATION_MESSAGE);
    }
}
