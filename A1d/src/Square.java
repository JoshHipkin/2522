public class Square extends Rectangle {
  /**
   * Constructs a new Rectangle object with the specified width and height.
   *
   * @param w The width of the rectangle.
   * @param h The height of the rectangle.
   */
  protected Square(final int w, final int h) throws Exception {
    super(w, w);
    if (width != height) {
      throw new Exception("BadWidthException");
    } else {
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          grid[i][j] = '*';
        }
      }
    }
  }
}
