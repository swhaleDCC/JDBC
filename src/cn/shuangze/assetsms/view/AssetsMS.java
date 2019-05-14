package cn.shuangze.assetsms.view;

import java.awt.*;

/**
 * 运行主类
 */
public class AssetsMS {
    boolean packFrame = false;
    public AssetsMS() {
        AssetsMain frame = new AssetsMain();             
        //设置运行时窗口的位置
        //Toolkit 的子类被用于将各种组件绑定到特定本机工具包实现
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//Toolkit是抽象类有静态方法getDefaultToolkit()
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        frame.setVisible(true);
    }
    public static void main(String[] args) {           		
	new AssetsMS();
    }
}