/**
 * Represents a rectangle, which is a specific type of geometric shape, extending the base Shape class.
 * It initializes and populates a 2D grid to represent the rectangle with '*' characters.
 */
public class Rectangle extends Shape {

  /**
   * Constructs a new Rectangle object with the specified width and height.
   *
   * @param w The width of the rectangle.
   * @param h The height of the rectangle.
   */
  protected Rectangle(final int w, final int h) {
    super(w, h, "r");

    // Fill the array with '*' to represent a rectangle.
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        grid[i][j] = '*';
      }
    }
  }
}
