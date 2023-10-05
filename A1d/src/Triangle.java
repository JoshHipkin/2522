/**
 * Represents a triangle, which is a specific type of geometric shape, extending the base Shape class.
 * It initializes and populates a 2D grid to represent the triangle with '@' characters.
 * The width of the triangle must be an odd number.
 *
 */
public class Triangle extends Shape {

  /**
   * Constructs a new Triangle object with the specified width and height.
   *
   * @param w The width of the triangle (must be an odd number).
   * @param h The height of the triangle.
   * @throws BadWidthException if the provided width is not an odd number.
   */
  protected Triangle(final int w, final int h) throws BadWidthException {
    // Call the constructor of the base class (Shape) to set width, height, and label.
    super(w, w / 2 + 1, "t");
    // Check if the width is even and throw an exception if it is.
    if (w % 2 == 0) {
      throw new BadWidthException();
    } else {


      int center = width / 2;
      int start = center;
      int end = center;

      // Populate the grid to represent the triangle with '@' characters.
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          if (start <= j && j <= end) {
            grid[i][j] = '@';
          }
        }
        start--;
        end++;
      }
    }
  }
}
