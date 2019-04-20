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
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//密码修改界面
public class LogModify extends JFrame implements ActionListener, ListSelectionListener {
    JLabel username=new JLabel();
    JLabel password=new JLabel();
    JTextField jTextField1 = new JTextField(20);
    JTextField jTextField2 = new JTextField(20);
    JButton log = new JButton(new ImageIcon("images\\save.png"));
    JButton clear = new JButton(new ImageIcon("images\\delete.png"));
    JPanel onePanel = new JPanel();
    JPanel twoPanel = new JPanel();
    JPanel threePanel = new JPanel();
    Container contentPane;
    Dimension faceSize = new Dimension(500,500);
    UsersDaoJDBCImpl userDao;
    Users item;

    public LogModify(){
        
        userDao=new UsersDaoJDBCImpl();
        try{
            init();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "修改密码", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void init() throws Exception{
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        setSize(500,500);
        this.setTitle("修改密码");
        this.setResizable(true);
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 400) / 2,
                (screenSize.height - 300) / 2 + 45);

        username.setText("输入密码");
        username.setFont(new Font("Dialog", 0, 12));
        onePanel.add(username);
        onePanel.add(jTextField1);
        contentPane.add(onePanel,BorderLayout.NORTH);
        
        password.setText("确认密码");
        password.setFont(new Font("Dialog", 0, 12));
        twoPanel.add(password);
        twoPanel.add(jTextField2);
        contentPane.add(twoPanel,BorderLayout.CENTER);
        
        log.setText("保存");
        log.setFont(new Font("Dialog", 0, 12));
        threePanel.add(log);
        log.addActionListener(this);
        log.setEnabled(true);
        
        clear.setText("重置");
        clear.setFont(new Font("Dialog", 0, 12));
        threePanel.add(clear);
        clear.addActionListener(this);
        clear.setEnabled(true);
        
        contentPane.add(threePanel,BorderLayout.SOUTH);    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        List l;
        if(obj==log){
            if(jTextField1.getText().trim().equals("")||jTextField2.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "密码和确认密码不能为空！", "修改密码", JOptionPane.INFORMATION_MESSAGE);
            }else if(!jTextField1.getText().trim().equals(jTextField2.getText().trim())){
                jTextField1.setText(null);
                jTextField2.setText(null);
                JOptionPane.showMessageDialog(null, "密码和确认密码不匹配！", "修改密码", JOptionPane.INFORMATION_MESSAGE);
            }else {
                try { 
                    item=LogAssets.u;
                    item.setPassword(jTextField1.getText());
                    userDao.modify(item);
                    //userDao.modify(new Users(LogAssets.u.getUserno(),LogAssets.u.getUsername(),jTextField1.getText(),LogAssets.u.getPhone(),LogAssets.u.getMail()));
                    JOptionPane.showMessageDialog(null, "修改成功！", "修改密码", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } catch (Exception ex) {
                    //Logger.getLogger(LogModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        }else if(obj==clear){
            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextField1.setEditable(true);
            jTextField2.setEditable(true);
            log.setEnabled(true);
            clear.setEnabled(true);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //JOptionPane.showMessageDialog(null, "错误操作！", "", JOptionPane.INFORMATION_MESSAGE);
    }
}
