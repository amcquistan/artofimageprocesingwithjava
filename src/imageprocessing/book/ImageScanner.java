/*
 * Source: The Art of Image Processing with Java (2010), page 394-395
 * Author: Kenny Hunt
 * Modifications: 
 *   1) The original source code uses the class ColRowBand in place of 
 *      my use of Location (which I assume are equivalent)
 *   2) The original source used java.awt.Rectangle, I swapped in javafx.scene.shape.Rectangle
 */

package imageprocessing.book;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javafx.scene.shape.Rectangle;

public abstract class ImageScanner implements Iterable<Location>, Iterator<Location> {
	
	protected static UnsupportedOperationException exception = new UnsupportedOperationException();
	protected Location current;
	protected int numBands;
	protected Rectangle region;
	
	public ImageScanner(Rectangle region, int numBands) {
		this.region = region;
		this.numBands = numBands;
		current = new Location(0, 0, 0);
	}
	
	public ImageScanner(Rectangle region) {
		this(region, 1);
	}
	
	public boolean hasMoreElements() {
		return hasNext();
	}
	
	public Location nextElement() throws NoSuchElementException {
		return next();
	}
	
	public void remove() {
		throw exception;
	}
	
	
	public Iterator<Location> iterator() {
		return this;
	}
	
}
