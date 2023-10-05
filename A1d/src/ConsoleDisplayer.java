/**
 * Displays shape in console.
 */
public class ConsoleDisplayer implements Displayer{

  /**
   * calls display method for the shape.
   * @param shape the shape to display.
   */
  @Override
  public void displayShape(Shape shape) {
    shape.display();
  }
}
