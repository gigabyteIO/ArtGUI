import java.util.Random;
import javafx.scene.paint.Color;

/**
 * Subclass of the abstract Art class. It is inspired by the artist Mangled Mondrian. 
 * @author Martin M.
 *
 */
public class PseudoMondrian extends Art {

	/**
	 * Create the canvas with a given size.  This just
	 * calls the method from the superclass, but it is
	 * required because constructors are not inherited.
	 */
	public PseudoMondrian(int width, int height) {
		super(width, height);
	}

	@Override
	protected void draw() {
		g.setFill(generateRandomPastelColor());
		g.fillRect(0, 0, this.width, this.height);

		int numberOfLines;	
		numberOfLines = (int) (20 * Math.random() + 4);

		for(int i = 0; i < numberOfLines; i++) {

			boolean isVertical;

			// Generates a value between 0.0 and 1.0
			double randomVerticalOrHorizontal;
			randomVerticalOrHorizontal = Math.random();

			if(randomVerticalOrHorizontal > .50) {
				isVertical = true;
			}
			else {
				isVertical = false;
			}

			// Generates random line width that isn't too big
			int randomLineWidth;
			randomLineWidth = (int) ( (this.width / 20) * Math.random());

			// Generate random color
			g.setFill(Color.color(Math.random(), Math.random(), Math.random(), 1.0) );
			g.setStroke(Color.BLACK);

			// Vertical line
			if(isVertical) {
				double randomX = this.height * Math.random();
				g.fillRect(randomX, 0, randomLineWidth, this.height);
				g.strokeRect(randomX, 0, randomLineWidth, this.height);

			}
			// Horizontal line
			else {
				double randomY = this.height * Math.random();
				g.fillRect(0, randomY, this.width, randomLineWidth);
				g.strokeRect(0, randomY, this.width, randomLineWidth);
			}
		}
		
	}
	
	/**
	 * Generates a random pastel color.
	 * @return Pastel color
	 */
	public Color generateRandomPastelColor() {
		Random random = new Random();
		final int base = 255,
				min = 26,
				max = 35;
		final int red = base - (random.nextInt(max - min + 1) + min);
		final int green = base - (random.nextInt(max - min + 1) + min);
		final int blue = base - (random.nextInt(max - min + 1) + min);

		return Color.rgb(red, green, blue);
	}

}
