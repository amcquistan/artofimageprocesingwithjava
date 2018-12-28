/*
 * Source: The Art of Image Processing with Java (2010), page 72
 * Author: Kenny Hunt
 * Modifications: 
 *   1) InvertOp#filter for-each iterator variable is renamed from pt to loc
 */

package imageprocessing.book;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class InvertOp extends NullOp {
	@Override
	public BufferedImage filter(BufferedImage src, BufferedImage dest) {
		if (dest == null) {
			dest = createCompatibleDestImage(src, src.getColorModel());
		}
		
		WritableRaster srcRaster = src.getRaster();
		WritableRaster destRaster = dest.getRaster();
		for (Location loc : new RasterScanner(src, true)) {
			int sample = srcRaster.getSample(loc.col, loc.row, loc.band);
			destRaster.setSample(loc.col, loc.row, loc.band, (255 - sample));
		}
		
		return dest;
	}
}
