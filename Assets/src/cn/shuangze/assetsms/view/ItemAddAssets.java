package cn.shuangze.assetsms.view;

import cn.shuangze.assetsms.dao.*;
import cn.shuangze.assetsms.dao.impl.*;
import cn.shuangze.assetsms.entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * 资产信息增加界面
 */
public class ItemAddAssets extends JFrame implements ActionListener, ListSelectionListener {
    ItemTypeDao itemTypeDao;
    AssetsTypeDao assetsTypeDao;
    int[] type;

    DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");
    DateChooser dateChooser2 = DateChooser.getInstance("yyyy-MM-dd");

    //定义图形界面元素
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JLabel nullLabel1 = new JLabel();
    JLabel nullLabel2 = new JLabel();
    JLabel nullLabel3 = new JLabel();
    JLabel nullLabel4 = new JLabel();
    JLabel nullLabel5 = new JLabel();
    JLabel nullLabel6 = new JLabel();
    JLabel nullLabel7 = new JLabel();
    JTextField jTextField1 = new JTextField(10);
    JTextField jTextField2 = new JTextField(10);
    JComboBox jTextField3=new JComboBox();
    JTextField jTextField4 = new JTextField(10);
    JTextField jTextField5 = new JTextField(10);
    JTextField jTextField6= new JTextField(10);
    JTextField jTextField7 = new JTextField(10);
    JTextField jTextField8 = new JTextField(10);

    JButton addAssets = new JButton(new ImageIcon("images\\save.png"));
    JButton clearInfo = new JButton(new ImageIcon("images\\delete.png"));
    //框架的大小
    Dimension faceSize = new Dimension(400,400);

    public ItemAddAssets() {
        itemTypeDao = new ItemTypeDaoJDBCImpl();
        assetsTypeDao = new AssetsTypeDaoJDBCImpl();
        //设置框架的大小
        try {
            init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "窗口初始化错误，错误原因：" + e.getMessage(), "资产信息增加错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void init() throws Exception {  
        this.setLayout(new GridLayout(0,5,0,20));       
        this.setSize(faceSize);
        type=assetsTypeDao.findAllID();
        //设置标题
        this.setTitle("资产增加");
        this.setResizable(true);
        //设置运行时窗口的位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - 400) / 2,
                (screenSize.height - 300) / 2 + 45);
              
        //label和TextField的布局
        jLabel1.setText("                                        资产编号");
        jLabel1.setFont(new Font("Dialog", 0, 12));
        jLabel1.setSize(20, 20);
        this.add(jLabel1);
        this.add(jTextField1);
        
        jLabel2.setText("                                        资产名称");
        jLabel2.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel2);
        this.add(jTextField2);
        
        nullLabel1.setText(null);
        nullLabel1.setFont(new Font("Dialog", 0, 12));
        this.add(nullLabel1);

        jLabel3.setText("                                        资产类型");
        jLabel3.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel3);
        if(type==null){
            jTextField3.addItem(null);
        }else{
            for(int i=0;i<type.length;i++){
                jTextField3.addItem(type[i]+":"+assetsTypeDao.findById(type[i]).getBigType()+"-"+assetsTypeDao.findById(type[i]).getSmallType());
            }
        }       
        jTextField3.setBounds(170, 170, 170, 170);
        this.add(jTextField3);
   
        jLabel4.setText("                                        资产型号");
        jLabel4.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel4);
        this.add(jTextField4);
        
        nullLabel2.setText(null);
        nullLabel2.setFont(new Font("Dialog", 0, 12));
        this.add(nullLabel2);
        
        jLabel5.setText("                                        资产价格");
        jLabel5.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel5);
        this.add(jTextField5);
     
        jLabel6.setText("                                        购买日期");
        jLabel6.setFont(new Font("Dialog", 0, 12));
        dateChooser1.register(jTextField6);
        dateChooser2.register(jLabel6);
        this.add(jLabel6);
        this.add(jTextField6);
        
        nullLabel3.setText(null);
        nullLabel3.setFont(new Font("Dialog", 0, 12));
        this.add(nullLabel3);

        jLabel7.setText("                                        状   态");
        jLabel7.setFont(new Font("Dialog", 0, 12));
        this.add(jLabel7);
        jTextField7.setText("可用");
        jTextField7.setEditable(false);
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
        
        //button的布局
        addAssets.setText("增加");
        addAssets.setFont(new Font("Dialog", 0, 12));
        this.add(addAssets);
        addAssets.addActionListener(this);
        addAssets.setEnabled(true);
        
        
        nullLabel6.setText(null);
        nullLabel6.setFont(new Font("Dialog", 0, 12));
        this.add(nullLabel6);
        
        clearInfo.setText("重置");
        clearInfo.setFont(new Font("Dialog", 0, 12));
        this.add(clearInfo);
        clearInfo.addActionListener(this);
        clearInfo.setEnabled(true);
        
        nullLabel7.setText(null);
        nullLabel7.setFont(new Font("Dialog", 0, 12));
        this.add(nullLabel7);
 
        jTextField1.setEditable(false);
        jTextField2.setEditable(true);
        jTextField4.setEditable(true);
        jTextField5.setEditable(true);
        jTextField6.setEditable(true);
        jTextField7.setEditable(false);
        jTextField8.setEditable(true);
    }

    /**
     * 事件处理
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == addAssets) {
            try {
                //增加资产信息
                String s=(String)jTextField3.getSelectedItem();
                char[] c=s.toCharArray();
                int txt=c[0]-48;
                itemTypeDao.add(new ItemType(jTextField2.getText(),txt ,jTextField4.getText(), jTextField5.getText(),jTextField6.getText(),jTextField7.getText(),jTextField8.getText()));
                JOptionPane.showMessageDialog(null, "资产增加成功！", "资产信息增加", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "数据库访问错误，错误原因：" + ex.getMessage(), "资产信息增加错误", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
            ItemAddAssets itemAdd = new ItemAddAssets();
            itemAdd.pack();
            itemAdd.setVisible(true);
        } else if (obj==clearInfo){
            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextField4.setText(null);
            jTextField5.setText(null);
            jTextField6.setText(null);
            jTextField7.setText(null);
            jTextField8.setText(null);
            jTextField1.setEditable(false);
            jTextField2.setEditable(true);
            jTextField4.setEditable(true);
            jTextField5.setEditable(true);
            jTextField6.setEditable(true);
            jTextField7.setText("可用");
            jTextField7.setEditable(false);
            jTextField8.setEditable(true);
            clearInfo.setEnabled(true);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
