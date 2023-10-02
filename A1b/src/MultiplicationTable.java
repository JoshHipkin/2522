/**
 * MultiplicationTable class, child of Table class.
 */
public class MultiplicationTable extends Table {

    /**
     * Constructs a MultiplicationTable object.
     * @param start the start value of the table.
     * @param stop the end value of the table.
     */
    protected MultiplicationTable(final int start, final int stop) {
        super(start, stop);
    }

    /**
     * Calculates the multiplication table by iterating through the values in
     * the specified range and storing the sums in the table array.
     */
    @Override
    protected void calculateTable() {
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < rows; j++) {
                float result = (start + i) * (start + j);
                table[i][j] = result;
                table[j][i] = result;
            }
        }
    }
}
