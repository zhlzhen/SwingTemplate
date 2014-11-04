/**
 * @name ibook
 * @version 0.0.1
 */
package util;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

/**
 * @author zhailzh
 * @date 2014-10-11
 */
public class ImageManager {

	private static HashMap<String, ImageIcon> imageRegistry = new HashMap<String, ImageIcon>();

	public static HashMap<String, ImageIcon> getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new HashMap<String, ImageIcon>();
		}
		return imageRegistry;
	}

	public static ImageIcon getImageIcon(String imageName) {
		return getImageIcon(imageName, null);
	}

	public static ImageIcon getImageIcon(String imageName, String description) {
		ImageIcon getImageIcon = imageRegistry.get(imageName);
		if (getImageIcon == null) {
			getImageIcon = description == null ? new ImageIcon(ResouceLoader
					.getResouce(imageName)) : new ImageIcon(ResouceLoader
					.getResouce(imageName), description);
			imageRegistry.put(imageName, getImageIcon);
		}
		return getImageIcon;
	}

	public static Image getImage(String imageName) {
		return getImageIcon(imageName).getImage();
	}
	
	/**
	 * 加载图片资源
	 * */
	public static ImageIcon getImageIconByShortName(String imageName) {
		return getImageIcon(Constant.ICON_DIR + imageName);
	}
	
	public static void main(String[] args) {
		// 测试加载图片资源
		
		ImageIcon icon = getImageIconByShortName("5.png");
		if(icon != null){
			System.out.println("success");
		}

	}

	public static Image getImageByName(String pngName) {
		return getImage(Constant.ICON_DIR + pngName);
	}

}
