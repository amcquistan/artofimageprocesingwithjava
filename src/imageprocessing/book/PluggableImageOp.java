/*
 * Source: The Art of Image Processing with Java (2010), page 76-77
 * Author: Kenny Hunt
 * Modifications: 
 */

package imageprocessing.book;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

public interface PluggableImageOp extends BufferedImageOp {

	String getAuthorName();
	BufferedImageOp getDefault(BufferedImage src);
}
