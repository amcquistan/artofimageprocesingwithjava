/*
 * Source: The Art of Image Processing with Java (2010), page 70
 * Author: Kenny Hunt
 */

package imageprocessing.book;

public class Location {
	public int row, col, band;
	
	public Location(int col, int row, int band) {
		this.col = col;
		this.row = row;
		this.band = band;
	}
}
