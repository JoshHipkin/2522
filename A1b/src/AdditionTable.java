/**
 * Addition table class, child class of Table.
 */
public class AdditionTable extends Table{

    /**
     * Constructs an AdditionTable object.
     * @param start the start value of the table.
     * @param stop the end value of the table.
     */
    public AdditionTable(final int start, final int stop) {
        super(start, stop);
    }

    /**
     * Calculates the addition table by iterating through the values in the specified range
     * and storing the sums in the table array.
     */
    @Override
    protected void calculateTable() {
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < rows; j++) {
                float result = (start + i) + (start + j);
                table[i][j] = result;
                table[j][i] = result;
            }
        }
    }
}
