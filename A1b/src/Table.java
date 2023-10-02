/**
 * Abstract Super class of table.
 */
public abstract class Table {
    protected int start;
    protected int stop;
    protected int rows;
    protected float[][] table;

    /**
     * Super constructor for Table class.
     * @param begin the starting value of the table.
     * @param end the ending value of the table.
     */
    protected Table(final int begin, final int end) {
    start = begin;
    stop = end;
    rows = stop - start + 1;
    table = new float[rows][rows];
    }

    /**
     * Calculates specific table, defined in each Subclass.
     */
    protected abstract void calculateTable();

    /**
     * Print out table of passed type parameter.
     * @param type the type of the table.
     */
    protected void display(TableType type) {
        switch (type) {
            case MULT -> System.out.print("    *");
            case ADD -> System.out.print("    +");
            default -> System.out.print("    ~");
        }
        for (int i = start; i <= stop; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();
        System.out.println("     " + "-".repeat(5 * table.length));
        for (int i = 0; i < table.length; i++) {
            System.out.printf("%3d", i + start);
            System.out.print(" |");
            for (int j = 0; j < table.length; j++) {
                System.out.printf("%5d", (int) table[i][j]);
            }
            System.out.println();
        }
    }
}
