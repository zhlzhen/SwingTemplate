/**
 * 
 */
package util;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * @author zhailzh
 *
 */
public class ResouceLoader {

	public static URL getFileURL(String url_name) {
		try {
			return new URL(Constant.PROTOCOL_FILE + url_name);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException("Malformed URL " + url_name, e);
		}
	}

	public static String getFilePath(String filePath) {
		return getFileURL(filePath).getPath();
	}

	public static URL getResouce(String url_name) {
		return ClassLoader.getSystemResource(url_name);
	}
}
