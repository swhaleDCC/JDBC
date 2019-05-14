package cn.shuangze.assetsms.view;

import cn.shuangze.assetsms.dao.*;
import cn.shuangze.assetsms.dao.impl.*;
import cn.shuangze.assetsms.entity.AssetsType;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 * 按编号查找界面
 */
public class ItemSelectIDAssets  extends JFrame implements ActionListener, ListSelectionListener {
    AssetsTypeDao assetsTypeDao;
    int[] assets;//编号
    //定义图形界面元素
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JLabel nullLabel1 = new JLabel();
    JLabel nullLabel2 = new JLabel();
    JLabel nullLabel3 = new JLabel();
    JLabel nullLabel4 = new JLabel();
    JLabel nullLabel5 = new JLabel();
    JLabel nullLabel6 = new JLabel();
    JLabel nullLabel7 = new JLabel();
    JTextField jTextField1 = new JTextField(15);
    JTextField jTextField2 = new JTextField(15);
    JTextField jTextField3=new JTextField(15);
    JTextField jTextField4 = new JTextField(15);
    JTextField jTextField5 = new JTextField(15);
    JTextField jTextField6 = new JTextField(15);
    JTextField jTextField7 = new JTextField(15);
    JTextField jTextField8 = new JTextField(15);
    JComboBox jTextField9=new JComboBox();
    JButton findAssets = new JButton(new ImageIcon("images\\search.png"));

    public ItemSelectIDAssets () {
        assetsTypeDao = new AssetsTypeDaoJDBCImpl();
        //设置框架的大小
        try {
            init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "资产信息按编号查找错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void init() throws Exception {  
        this.setLayout(new GridLayout(0,5,0,20));       
        //设置标题
        this.setTitle("按编号查找");
        this.setResizable(true);
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 400) / 2,
                (screenSize.height - 300) / 2 + 45);
              
        //label和TextField的布局
        jLabel1.setText("                                        生物编号");
        jLabel1.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel1);
        this.add(jTextField1);
        
        jLabel2.setText("                                        中文学名");
        jLabel2.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel2);
        this.add(jTextField2);
        
        nullLabel1.setText(null);
        nullLabel1.setFont(new Font("Dialog", 0, 12));
        this.add(nullLabel1);

        jLabel3.setText("                                        拉丁名");
        jLabel3.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel3);
        this.add(jTextField3);
   
        jLabel4.setText("                                        分类信息");
        jLabel4.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel4);
        this.add(jTextField4);
        
        nullLabel2.setText(null);
        nullLabel2.setFont(new Font("Dialog", 0, 12));
        this.add(nullLabel2);
        
        jLabel5.setText("                                        生物学特征");
        jLabel5.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel5);
        this.add(jTextField5);
     
        jLabel6.setText("                                        生态分布");
        jLabel6.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel6);
        this.add(jTextField6);
        
        nullLabel3.setText(null);
        nullLabel3.setFont(new Font("Dialog", 0, 12));
        this.add(nullLabel3);

        jLabel7.setText("                                        文献信息");
        jLabel7.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel7);
        this.add(jTextField7);
   
        jLabel8.setText("                                        备   注");
        jLabel8.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel8);
        this.add(jTextField8);
        
        nullLabel4.setText(null);
        nullLabel4.setFont(new Font("Dialog", 0, 12));
        this.add(nullLabel4);
        
        nullLabel5.setText(null);
        nullLabel5.setFont(new Font("Dialog", 0, 12));
        this.add(nullLabel5);
        
        assets=assetsTypeDao.findAllID();
        jLabel9.setText("                                        编   号");
        jLabel9.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel9);
        for(int i=0;i<assets.length;i++){
            jTextField9.addItem(assets[i]);
        }  
        this.add(jTextField9);
        //button的布局
        findAssets.setText("按编号查找");
        findAssets.setFont(new Font("Dialog", 0, 12));
        this.add(findAssets);
        findAssets.addActionListener(this);
        findAssets.setEnabled(true);
        
        nullLabel7.setText(null);
        nullLabel7.setFont(new Font("Dialog", 0, 12));
        this.add(nullLabel7);
 
        jTextField1.setEditable(false);
        jTextField2.setEditable(true);
        jTextField4.setEditable(true);
        jTextField5.setEditable(true);
        jTextField6.setEditable(true);
        jTextField7.setEditable(true);
        jTextField8.setEditable(true);
    }

    /**
     * 事件处理
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == findAssets) {
            try {
                //按编号查找
                AssetsType item=assetsTypeDao.findById((int)jTextField9.getSelectedItem());

                jTextField1.setText(String.valueOf(item.getCreatureno()));
                jTextField2.setText(item.getChinaname());
                jTextField3.setText(item.getLatinname());
                jTextField4.setText(item.getCategory());
                jTextField5.setText(item.getFeature());
                jTextField6.setText(item.getDistributed());
                jTextField7.setText(item.getLiterature());
                jTextField8.setText(item.getRemarks());
                JOptionPane.showMessageDialog(null, "查找成功！", "按编号查找", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            //this.setSize(faceSize);  
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //JOptionPane.showMessageDialog(null, "错误操作！", "", JOptionPane.INFORMATION_MESSAGE);
    }
}
