/*
 * Source: The Art of Image Processing with Java (2010), page 394-395
 * Author: Kenny Hunt
 * Modifications: 
 */

package imageprocessing.book;

import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javafx.scene.shape.Rectangle;

public class RasterScanner extends ImageScanner {
	
	protected int index;
	protected int maxIndex;
	
	public RasterScanner(BufferedImage image, Rectangle region, boolean isBanded) {
		super(region, isBanded ? image.getRaster().getNumBands() : 1);
		maxIndex = (int) (region.getWidth() * region.getHeight() * numBands);
		index = -1;
		current.col = getCol();
		current.row = getRow();
		current.band = getBand();
	}
	
	public RasterScanner(BufferedImage image, boolean isBanded) {
		this(image, new Rectangle(0, 0, image.getWidth(), image.getHeight()), isBanded);
	}
	
	public int getCol() {
		return (index / numBands) % (int) region.getWidth();
	}
	
	public int getRow() {
		return index / (numBands * (int) region.getWidth());
	}
	
	public int getBand() {
		return index % numBands;
	}

	@Override
	public boolean hasNext() {
		return index < (maxIndex - 1);
	}

	@Override
	public Location next() {
		if (!hasMoreElements()) {
			throw new NoSuchElementException();
		}
		
		index++;
		current.row = getRow();
		current.col = getCol();
		current.band = getBand();
		return current;
	}

}
