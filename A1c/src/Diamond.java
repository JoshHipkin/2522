/**
 * Represents a diamond, which is a specific type of geometric shape, extending the base Shape class.
 * It initializes and populates a 2D grid to represent the diamond with '#' characters.
 * The width of the diamond must be an odd number.
 */
public class Diamond extends Shape {

  /**
   * Constructs a new Diamond object with the specified width and height.
   *
   * @param w The width of the diamond (must be an odd number).
   * @param h The height of the diamond.
   * @throws BadWidthException If the provided width is not an odd number.
   */
  protected Diamond(int w, int h) throws BadWidthException {
    super(w, w, "d");

    //check if width is odd, otherwise throw an exception.
    if (w % 2 == 0) {
      throw new BadWidthException();
    }

    // set some variables to control the shape of the diamond.
    int center = width / 2;
    int start = center;
    int end = center;

    // Fill in the spaces between the bounds of the diamond with '#'.
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (start <= j && j <= end) {
          grid[i][j] = "#";
        }
      }
      // Increase bound width below half, and decrease after wards.
      if (i < height / 2) {
        start--;
        end++;
      } else {
        start++;
        end--;
      }
    }
  }
}
