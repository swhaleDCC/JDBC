package cn.shuangze.assetsms.view;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 * 资产管理系统---主界面
 */
public class AssetsMain extends JFrame implements ActionListener {
    //框架的大小
    Dimension faceSize = new Dimension(850,600);
    //建立菜单栏
    JMenuBar mainMenu = new JMenuBar();
    JPanel jPanel = new JPanel();
    
    //建立“系统管理”菜单组
    JMenu menuSystem = new JMenu();
    JMenuItem itemTypeMan = new JMenuItem();//类别管理
    JMenuItem itemExit = new JMenuItem();//退出

    //建立“资产信息管理”菜单组
    JMenu menuAssets = new JMenu();
    JMenuItem itemAddAssets = new JMenuItem();//增加
    JMenuItem itemModifyAssets = new JMenuItem();//修改
    JMenuItem itemDeleteAssets = new JMenuItem();//删除
    JMenu itemSelectAssets = new JMenu();//查询
    JMenuItem itemSelectAssetsAll = new JMenuItem();//查询所有
    JMenuItem itemSelectAssetsID = new JMenuItem();//按编号查询
    
    //建立“人员信息管理”菜单组
    JMenu menuPerson = new JMenu();
    JMenuItem itemAddPerson = new JMenuItem();//人员信息增加
    JMenuItem itemModifyPerson = new JMenuItem();//人员信息修改
    JMenuItem itemDeletePerson = new JMenuItem();//人员信息删除
    JMenu itemSelectPerson = new JMenu();//查询人员信息
    JMenuItem itemSelectPersonAll = new JMenuItem();//查询所有
    JMenuItem itemSelectPersonID = new JMenuItem();//按编号查询
    
    //建立“资产领用”菜单组
    JMenu menuUsing = new JMenu();
    JMenuItem itemUsing = new JMenuItem();//资产领用管理
    JMenuItem itemSelectUsing = new JMenuItem();//领用信息查询
    
    //建立“资产归还”菜单组
    JMenu menuBack = new JMenu();
    JMenuItem itemBack = new JMenuItem();//资产归还管理
    JMenuItem itemSelectBack = new JMenuItem();//归还信息查询
    
    //建立“资产报废”菜单组
    JMenu menuInvalid = new JMenu();
    JMenuItem itemInvalid = new JMenuItem();//资产报废管理
    JMenuItem itemSelectInvalid = new JMenuItem();//报废信息查询
        
    //建立“登录”菜单组
    JMenu menuLog = new JMenu();
    JMenuItem itemLog = new JMenuItem();
    JMenuItem itemRegister = new JMenuItem();
    JMenuItem itemLogExit = new JMenuItem();
    
    boolean log=LogAssets.successLog;;

    //构造函数
    public AssetsMain() {
        try {
            this.init();
        } catch (Exception ex) {
            Logger.getLogger(AssetsMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //初始化方法
    private void init() throws Exception {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        //设置框架的大小
        this.setSize(faceSize);
        //设置标题
        this.setTitle("资产管理系统");
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        //添加菜单组
        menuSystem.setText("系统管理");
        menuSystem.setFont(new Font("Dialog", 0, 12));
        menuAssets.setText("资产信息管理");
        menuAssets.setFont(new Font("Dialog", 0, 12));
        menuPerson.setText("人员信息管理");
        menuPerson.setFont(new Font("Dialog", 0, 12));
        menuUsing.setText("资产领用");
        menuUsing.setFont(new Font("Dialog", 0, 12));
        menuBack.setText("资产归还");
        menuBack.setFont(new Font("Dialog", 0, 12));
        menuInvalid.setText("资产报废");
        menuInvalid.setFont(new Font("Dialog", 0, 12));
        menuLog.setText("登录");
        menuLog.setFont(new Font("Dialog", 0, 12));
        
        //生成“登录”菜单组的选项
        itemLog.setText("登录");
        itemLog.setFont(new Font("Dialog", 0, 12));
        itemRegister.setText("注册");
        itemRegister.setFont(new Font("Dialog", 0, 12));
        itemLogExit.setText("退出");
        itemLogExit.setFont(new Font("Dialog", 0, 12));
        
        //生成“系统管理”菜单组的选项
        itemTypeMan.setText("类别管理");
        itemTypeMan.setFont(new Font("Dialog", 0, 12));
        itemExit.setText("退出");
        itemExit.setFont(new Font("Dialog", 0, 12));
        
        //生成“资产信息管理”菜单组的选项
        itemAddAssets.setText("增加");
        itemAddAssets.setFont(new Font("Dialog", 0, 12));
        itemModifyAssets.setText("修改");
        itemModifyAssets.setFont(new Font("Dialog", 0, 12));
        itemDeleteAssets.setText("删除");
        itemDeleteAssets.setFont(new Font("Dialog", 0, 12));
        itemSelectAssets.setText("查询");
        itemSelectAssets.setFont(new Font("Dialog", 0, 12));
        itemSelectAssetsAll.setText("查询所有");
        itemSelectAssetsAll.setFont(new Font("Dialog", 0, 12));
        itemSelectAssetsID.setText("按编号查询");
        itemSelectAssetsID.setFont(new Font("Dialog", 0, 12));
        
        //生成“人员信息管理”菜单组的选项
        itemAddPerson.setText("增加");
        itemAddPerson.setFont(new Font("Dialog", 0, 12));
        itemModifyPerson.setText("修改");
        itemModifyPerson.setFont(new Font("Dialog", 0, 12));
        itemDeletePerson.setText("删除");
        itemDeletePerson.setFont(new Font("Dialog", 0, 12));
        itemSelectPerson.setText("查询");
        itemSelectPerson.setFont(new Font("Dialog", 0, 12));
        itemSelectPersonAll.setText("查询所有");
        itemSelectPersonAll.setFont(new Font("Dialog", 0, 12));
        itemSelectPersonID.setText("按编号查询");
        itemSelectPersonID.setFont(new Font("Dialog", 0, 12));
        
        //生成“资产领用”菜单组的选项
        itemUsing.setText("资产领用管理");
        itemUsing.setFont(new Font("Dialog", 0, 12));
        itemSelectUsing.setText("领用信息查询");
        itemSelectUsing.setFont(new Font("Dialog", 0, 12));
        
        //生成“资产归还”菜单组的选项
        itemBack.setText("资产归还管理");
        itemBack.setFont(new Font("Dialog", 0, 12));
        itemSelectBack.setText("归还信息查询");
        itemSelectBack.setFont(new Font("Dialog", 0, 12));
        
        //生成“资产报废”菜单组的选项
        itemInvalid.setText("资产报废管理");
        itemInvalid.setFont(new Font("Dialog", 0, 12));
        itemSelectInvalid.setText("报废信息查询");
        itemSelectInvalid.setFont(new Font("Dialog", 0, 12));

        //添加“登录”菜单组
        menuLog.add(itemLog);
        menuLog.add(itemRegister);
        menuLog.add(itemLogExit);
 
        //添加“系统管理”菜单组
        menuSystem.add(itemTypeMan);
        menuSystem.add(itemExit);
        
        //添加“资产信息管理”菜单组
        menuAssets.add(itemAddAssets);
        menuAssets.add(itemModifyAssets);
        menuAssets.add(itemDeleteAssets);
        menuAssets.addSeparator();
        menuAssets.add(itemSelectAssets);
        itemSelectAssets.add(itemSelectAssetsAll);
        itemSelectAssets.add(itemSelectAssetsID);
        
        //添加“人员信息管理”菜单组
        menuPerson.add(itemAddPerson);
        menuPerson.add(itemModifyPerson);
        menuPerson.add(itemDeletePerson);
        menuPerson.addSeparator();
        menuPerson.add(itemSelectPerson);
        itemSelectPerson.add(itemSelectPersonAll);
        itemSelectPerson.add(itemSelectPersonID);
        
        //添加“资产领用”菜单组
        menuUsing.add(itemUsing);
        menuUsing.add(itemSelectUsing);
        
        //添加“资产归还”菜单组
        menuBack.add(itemBack);
        menuBack.add(itemSelectBack);
        
        //添加“资产报废”菜单组
        menuInvalid.add(itemInvalid);
        menuInvalid.add(itemSelectInvalid);

        //添加所有的菜单组
        mainMenu.add(menuSystem);
        mainMenu.add(menuAssets);
        mainMenu.add(menuPerson);
        mainMenu.add(menuUsing);
        mainMenu.add(menuBack);
        mainMenu.add(menuInvalid);
        mainMenu.add(menuLog);
        this.setJMenuBar(mainMenu);

        //添加事件侦听
        menuLog.addActionListener(this);
        itemTypeMan.addActionListener(this);
        itemExit.addActionListener(this);
        itemAddAssets.addActionListener(this);
        itemModifyAssets.addActionListener(this);
        itemDeleteAssets.addActionListener(this);
        itemSelectAssetsAll.addActionListener(this);
        itemSelectAssetsID.addActionListener(this);
        itemAddPerson.addActionListener(this);
        itemModifyPerson.addActionListener(this);
        itemDeletePerson.addActionListener(this);
        itemSelectPersonAll.addActionListener(this);
        itemSelectPersonID.addActionListener(this);
        itemUsing.addActionListener(this);
        itemSelectUsing.addActionListener(this);
        itemBack.addActionListener(this);
        itemSelectBack.addActionListener(this);
        itemInvalid.addActionListener(this);
        itemSelectInvalid.addActionListener(this);
        itemLog.addActionListener(this);
        itemRegister.addActionListener(this);
        itemLogExit.addActionListener(this);

        //关闭程序时的操作
        this.addWindowListener(
                new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        //添加背景图片
        ImageIcon img=new ImageIcon("images\\background5.jpg");
	//将背景图片放在标签里
	JLabel imgLabel=new JLabel(img);
	//将背景标签添加到jfram的LayeredPane面板里。
	this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
	//设置背景标签的位置 
	imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
	JPanel jp = (JPanel)this.getContentPane();
	jp.setOpaque(false);//透明
        
        //设置主界面的字体
        JLabel jLabel1=new JLabel();
        JLabel jLabel2=new JLabel();
        jLabel1.setText("                资产管理系统");
        jLabel1.setFont(new Font("华文新魏",1, 50));
        this.add(jLabel1,BorderLayout.CENTER);
        jLabel2.setText("                                                      "
                + "                           小组成员：XXX  XXX  XXX");
        jLabel2.setFont(new Font("华文中宋",0, 20));
        this.add(jLabel2,BorderLayout.SOUTH);
    }

    /**
     * 事件处理
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        log=LogAssets.successLog;
        if(obj==itemLog){//登录
            if(log){
                JOptionPane.showMessageDialog(null, "已登录，请先退出！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                LogAssets l=new LogAssets();
                l.pack();
                l.setVisible(true);   
            }
        }else if(obj==itemLogExit){//退出登录
            if(log){
                LogAssets.successLog=false;
                log=false;
                JOptionPane.showMessageDialog(null, "用户已退出！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(obj==itemRegister){//注册
            LogRegister lll=new LogRegister();
            lll.pack();
            lll.setVisible(true);
        }else if (obj == itemExit) { //退出
            System.exit(0);
        } else if (obj == itemTypeMan) { //资产类别管理
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                TypeInfo typeMan = new TypeInfo();
                typeMan.downInit();
                typeMan.pack();
                typeMan.setVisible(true);
            }
        } else if (obj == itemAddAssets) { //添加资产信息
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                ItemAddAssets itemAdd = new ItemAddAssets();
                itemAdd.pack();
                itemAdd.setVisible(true);
            }
        } else if (obj == itemModifyAssets) { //修改资产信息
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                ItemModifyAssets itemModify=new ItemModifyAssets();
                itemModify.pack();
                itemModify.setVisible(true);
            }
        } else if (obj == itemDeleteAssets) { //删除资产信息
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                ItemDeleteAssets itemDelete=new ItemDeleteAssets();
                itemDelete.pack();
                itemDelete.setVisible(true);
            }
        } else if (obj == itemSelectAssetsAll) { //查询所有资产信息
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
               ItemSelectAssets itemSelect=new ItemSelectAssets();
                itemSelect.pack();
                itemSelect.setVisible(true);
            }
        } else if (obj == itemSelectAssetsID) { //按编号查询资产信息
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                ItemSelectIDAssets itemSelectID=new ItemSelectIDAssets();
                itemSelectID.pack();
                itemSelectID.setVisible(true);
            }
        } else if (obj == itemAddPerson) { //添加人员信息
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                PersonAddAssets personAdd=new PersonAddAssets();
                personAdd.pack();
                personAdd.setVisible(true);
            }
        } else if (obj == itemModifyPerson) { //修改人员信息
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                PersonModifyAssets personModify=new PersonModifyAssets();
                personModify.pack();
                personModify.setVisible(true);
            }
        } else if (obj == itemDeletePerson) { //删除人员信息
             if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                PersonDeleteAssets personDelete=new PersonDeleteAssets();
                personDelete.pack();
                personDelete.setVisible(true);
            }
        } else if (obj == itemSelectPersonAll) { //查询所有人员信息
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                PersonSelectAssets personSelect=new PersonSelectAssets();
                personSelect.pack();
                personSelect.setVisible(true);
            }
        } else if (obj == itemSelectPersonID) { //按编号查询人员信息
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                PersonSelectIDAssets personSelectID=new PersonSelectIDAssets();
                personSelectID.pack();
                personSelectID.setVisible(true);
            } 
        } else if (obj == itemUsing) { //资产领用
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                ItemUsing itemUse = new ItemUsing();
                itemUse.pack();
                itemUse.setVisible(true);
            }
        } else if (obj == itemSelectUsing) { //领用信息查询
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                ItemUsingSelect itemUsingSelect=new ItemUsingSelect();
                itemUsingSelect.pack();
                itemUsingSelect.setVisible(true);
            }
        } else if (obj == itemBack) { //资产归还
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                ItemBack itemBack=new ItemBack();
                itemBack.pack();
                itemBack.setVisible(true);
            }
        } else if (obj == itemSelectBack) { //归还信息查询
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                ItemBackSelect backSelect=new ItemBackSelect();
                backSelect.pack();
                backSelect.setVisible(true);
            }
        } else if (obj == itemInvalid) { //资产报废
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                ItemInvalid itemInvalid=new ItemInvalid();
                itemInvalid.pack();
                itemInvalid.setVisible(true);
            }
        } else if (obj == itemSelectInvalid) { //报废信息查询
            if(log==false){
                JOptionPane.showMessageDialog(null, "请先登录！", "资产信息管理系统", JOptionPane.INFORMATION_MESSAGE);
            }else{
                ItemInvalidSelect invalidSelect=new ItemInvalidSelect();
                invalidSelect.pack();
                invalidSelect.setVisible(true);
            }
        }
    }
}
