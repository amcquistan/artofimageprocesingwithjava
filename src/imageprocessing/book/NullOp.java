/*
 * Source: The Art of Image Processing with Java (2010), page 72
 * Author: Kenny Hunt
 * Modifications: 
 *   1) NullOp#filter for-each iterator variable is renamed from pt to loc
 */


package imageprocessing.book;

import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class NullOp implements BufferedImageOp {

	@Override
	public BufferedImage createCompatibleDestImage(BufferedImage src, ColorModel destCM) {
		return new BufferedImage(
				destCM,
				destCM.createCompatibleWritableRaster(src.getWidth(), src.getHeight()),
				destCM.isAlphaPremultiplied(),
				null);
	}
	
	@Override
	public BufferedImage filter(BufferedImage src, BufferedImage dest) {
		if (dest == null) {
			dest = createCompatibleDestImage(src, src.getColorModel());
		}
		WritableRaster srcRaster = src.getRaster();
		WritableRaster destRaster = dest.getRaster();
		for (Location loc : new RasterScanner(src, true)) {
			int sample = srcRaster.getSample(loc.col, loc.row, loc.band);
			destRaster.setSample(loc.col, loc.row, loc.band, sample);
		}
		return dest;
	}

	@Override
	public Rectangle2D getBounds2D(BufferedImage src) {
		return src.getRaster().getBounds();
	}

	@Override
	public Point2D getPoint2D(Point2D srcPt, Point2D dstPt) {
		if (dstPt == null) {
			dstPt = (Point2D) srcPt.clone();
		} else {
			dstPt.setLocation(srcPt);
		}
		return dstPt;
	}

	@Override
	public RenderingHints getRenderingHints() {
		return null;
	}
}
