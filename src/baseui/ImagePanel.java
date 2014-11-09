/**
 * @name ibook
 * @version 0.0.1
 */
package baseui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * @author zhailzh
 * @date 2014-10-11 含有图片的背景
 */
public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	protected Image image = null;

	public ImagePanel(Image image) {
		this.image = image;
	}

	// 固定背景图片，允许这个JPanel可以在图片上添加其他组件
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
