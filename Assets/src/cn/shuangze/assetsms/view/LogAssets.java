package cn.shuangze.assetsms.view;
import cn.shuangze.assetsms.dao.impl.UsersDaoJDBCImpl;
import cn.shuangze.assetsms.entity.Users;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//登录界面
public class LogAssets extends JFrame implements ActionListener, ListSelectionListener {
    JLabel username=new JLabel();
    JLabel password=new JLabel();
    JTextField jTextField1 = new JTextField(20);
    JPasswordField jTextField2 = new JPasswordField(20);
    JButton log = new JButton(new ImageIcon("images\\down.png"));
    JButton clear = new JButton(new ImageIcon("images\\delete.png"));
    JButton modify = new JButton(new ImageIcon("images\\preview.png"));
    JPanel onePanel = new JPanel();
    JPanel twoPanel = new JPanel();
    JPanel threePanel = new JPanel();
    Container contentPane;
    Dimension faceSize = new Dimension(500,500);
    UsersDaoJDBCImpl userDao;
    public static Users u;
    public static boolean successLog;

    public LogAssets(){
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
        setSize(500,500);
        this.setTitle("登录");
        this.setResizable(true);
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 400) / 2,
                (screenSize.height - 300) / 2 + 45);
        
        username.setText("用户名");
        username.setFont(new Font("Dialog", 0, 12));
        onePanel.add(username);
        onePanel.add(jTextField1);
        contentPane.add(onePanel,BorderLayout.NORTH);
        
        password.setText("密    码");
        password.setFont(new Font("Dialog", 0, 12));
        twoPanel.add(password);
        twoPanel.add(jTextField2);
        contentPane.add(twoPanel,BorderLayout.CENTER);
        
        log.setText("登录");
        log.setFont(new Font("Dialog", 0, 12));
        threePanel.add(log);
        log.addActionListener(this);
        log.setEnabled(true);
        
        clear.setText("重置");
        clear.setFont(new Font("Dialog", 0, 12));
        threePanel.add(clear);
        clear.addActionListener(this);
        clear.setEnabled(true);
        
        modify.setText("修改密码");
        modify.setFont(new Font("Dialog", 0, 12));
        threePanel.add(modify);
        modify.addActionListener(this);
        modify.setEnabled(true);
        
        contentPane.add(threePanel,BorderLayout.SOUTH);    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        List l;
        String password=new String(jTextField2.getPassword());
        if(obj==log){
            try {
                if(jTextField1.getText().trim().equals("") || password.trim().equals("")){
                    successLog=false;
                    JOptionPane.showMessageDialog(null, "用户名或密码不能为空！", "登录", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    l=userDao.findAllName();
                    if(!l.contains(jTextField1.getText())){
                        successLog=false;
                        jTextField1.setText(null);
                        jTextField2.setText(null);
                        JOptionPane.showMessageDialog(null, "用户名不存在！", "登录", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        u=userDao.findNameUser(jTextField1.getText());
                        if(!password.equals(u.getPassword())){//密码不正确
                            jTextField2.setText(null);
                            JOptionPane.showMessageDialog(null, "密码错误！", "登录", JOptionPane.INFORMATION_MESSAGE);
                            successLog=false;
                        }else{//密码正确
                                successLog=true;
                                JOptionPane.showMessageDialog(null, "登录成功！", "登录", JOptionPane.INFORMATION_MESSAGE);
                                this.dispose();
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(LogAssets.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }else if(obj==clear){
            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextField1.setEditable(true);
            jTextField2.setEditable(true);
            log.setEnabled(true);
            clear.setEnabled(true);
        }else if(obj==modify){
            try {
                if(jTextField1.getText().trim().equals("") || password.trim().equals("")){
                    successLog=false;
                    JOptionPane.showMessageDialog(null, "用户名或密码不能为空！", "修改密码", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    l=userDao.findAllName();
                    if(!l.contains(jTextField1.getText())){
                        successLog=false;
                        jTextField1.setText(null);
                        jTextField2.setText(null);
                        JOptionPane.showMessageDialog(null, "用户名不存在！", "修改密码", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        u=userDao.findNameUser(jTextField1.getText());
                        if(!password.equals(u.getPassword())){//密码不正确
                            jTextField2.setText(null);
                            JOptionPane.showMessageDialog(null, "密码错误！", "修改密码", JOptionPane.INFORMATION_MESSAGE);
                            successLog=false;
                        }else{//密码正确
                                LogModify m=new LogModify();
                                m.pack();
                                m.setVisible(true);
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(LogAssets.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JOptionPane.showMessageDialog(null, "错误操作！", "", JOptionPane.INFORMATION_MESSAGE);
    }
}
