public class RTriangle extends Shape{

  /**
   * Constructs a new Triangle object with the specified width and height.
   *
   * @param w The width of the triangle (must be an odd number).
   * @param h The height of the triangle.
   * @throws BadWidthException if the provided width is not an odd number.
   */
  protected RTriangle(final int w, final int h) throws BadWidthException {

    //As per the jar example, use width as height.
    super(w, w, "Rt");

    int bound = width - 1;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (j >= bound) {
          grid[i][j] = '@';
        }
      }
      bound--;
    }
  }
}
