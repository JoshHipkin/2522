import javax.swing.JFrame;

public class SwingDisplayer implements Displayer {
    public void displayTable(final Shape shape) {
        final DisplayerFrame frame;

        frame = new DisplayerFrame();
        frame.init(shape);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void displayShape(Shape shape) {
        displayTable(shape);
    }
}