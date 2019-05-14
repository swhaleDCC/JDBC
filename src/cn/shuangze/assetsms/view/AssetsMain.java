package cn.shuangze.assetsms.view;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 * 主界面
 */
public class AssetsMain extends JFrame implements ActionListener {
    //框架的大小
    Dimension faceSize = new Dimension(850,600);
    //建立菜单栏
    JMenuBar mainMenu = new JMenuBar();
    JPanel jPanel = new JPanel();
    
    //信息管理
    JMenu menuSystem = new JMenu();
    JMenuItem itemTypeMan = new JMenuItem();//基本信息
    JMenuItem itemExit = new JMenuItem();//退出

    //查询
    JMenu itemSelectAssets = new JMenu();//查询
    JMenuItem itemSelectAssetsAll = new JMenuItem();//查询所有
    JMenuItem itemSelectAssetsID = new JMenuItem();//按编号查询
    
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
        this.setTitle("污损生物管理系统");
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        //信息管理菜单组
        menuSystem.setText("信息管理");
        menuSystem.setFont(new Font("Dialog", 0, 12));
        itemTypeMan.setText("基本信息");
        itemTypeMan.setFont(new Font("Dialog", 0, 12));
        itemExit.setText("退出");
        itemExit.setFont(new Font("Dialog", 0, 12));
        menuSystem.add(itemTypeMan);
        menuSystem.add(itemExit);
        
        //查询菜单组
        itemSelectAssets.setText("信息查询");
        itemSelectAssets.setFont(new Font("Dialog", 0, 12));
        itemSelectAssets.setText("查询");
        itemSelectAssets.setFont(new Font("Dialog", 0, 12));
        itemSelectAssetsAll.setText("查询所有");
        itemSelectAssetsAll.setFont(new Font("Dialog", 0, 12));
        itemSelectAssetsID.setText("按编号查询");
        itemSelectAssetsID.setFont(new Font("Dialog", 0, 12));
        itemSelectAssets.add(itemSelectAssetsAll);
        itemSelectAssets.add(itemSelectAssetsID);
        
        //添加所有的菜单组
        mainMenu.add(menuSystem);
        mainMenu.add(itemSelectAssets);
        this.setJMenuBar(mainMenu);

        //添加事件侦听
        itemTypeMan.addActionListener(this);
        itemExit.addActionListener(this);
        itemSelectAssetsAll.addActionListener(this);
        itemSelectAssetsID.addActionListener(this);

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
        jLabel1.setText("             污损生物管理系统");
        jLabel1.setFont(new Font("华文新魏",1, 50));
        this.add(jLabel1,BorderLayout.CENTER);
    }

    /**
     * 事件处理
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == itemExit) { //退出
            System.exit(0);
        } else if (obj == itemTypeMan) { 
            TypeInfo typeMan = new TypeInfo();
            typeMan.pack();
            typeMan.setVisible(true);
        }
        else if (obj == itemSelectAssetsAll) { 
            ItemSelectAssets all = new ItemSelectAssets();
            all.pack();
            all.setVisible(true);
        }
        else if (obj == itemSelectAssetsID) { 
            ItemSelectIDAssets id = new ItemSelectIDAssets();
            id.pack();
            id.setVisible(true);
        }
    }
}
