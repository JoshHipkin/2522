/**
 * This is an abstract base class for representing geometric shapes in a 2D grid.
 * It provides a basic structure for storing and displaying shapes.
 */
public abstract class Shape {
  protected int width;
  protected int height;
  String t;
  protected String[][] grid;

  /**
   * Constructs a new Shape object with the specified width, height, and label.
   *
   * @param width  The width of the shape.
   * @param height The height of the shape.
   * @param t      identifies the type of shape.
   */
  protected Shape(final int width, final int height, final String t) {
    this.width = width;
    this.height = height;
    this.t = t;
    grid = new String[this.height][this.width];

    //Initialize the grid array with spaces.
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        grid[i][j] = " ";
      }
    }
  }

  /**
   * Displays the shape by printing the grid array.
   */
  protected void display() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        System.out.print(grid[i][j]);
      }
      if (i < height - 1) {
        System.out.println();
      }
    }
  }
}
