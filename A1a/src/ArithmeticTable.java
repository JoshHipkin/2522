public class ArithmeticTable {

    /**
     * Enum of TableType.
     */
    public enum TableType {
        MULT,
        ADD
    }
    private TableType tableType;
    private int start;
    private int end;
    private float[][] table;
    public boolean argumentCheck(String[] args){
        if(args.length != 3){
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, \"*\"");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }

        if(args[0].charAt(0) == '+')
            tableType = TableType.ADD;
        else
            tableType = TableType.MULT;
        int sta;
        int sto;

        try{
            sta = Integer.parseInt(args[1]);
            sto = Integer.parseInt(args[2]);
        }
        catch(NumberFormatException ex){
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, \"*\"");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }

        if((sta < 1 || sta > 100)||((sto < 1 || sto > 100))){
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, \"*\"");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }

        if(sta >= sto){
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +,\"*\"");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }

        start = sta;
        end = sto;
        return true;
    }

    /**
     * Create the table size using the two ends of the table size, inclusively.
     * @param begin int beginning of table.
     * @param finish int ending of table.
     * @param tableType TableType of either multiplication or addition.
     */
    public void createTable(int begin, int finish, TableType tableType) {
        int rows = finish - begin + 1;
        table = new float[rows][rows];
        float result;
        for (int i = begin; i <= finish; i++) {
            for (int j = i; j <= finish; j++) {
                if (tableType == TableType.MULT) {
                    result = i * j;
                } else if (tableType == TableType.ADD) {
                    result = i + j;
                } else {
                    result = 0;
                }
                /*
                 * We calculate the first half of the table to find all initial values and store it in result
                 * and then input them into all cells where they would be duplicate. ex. a * b is the same as b * a.
                 * However, there will still be some duplicates that are calculated twice such as 3 * 4, and
                 * 6 * 2.
                 */
                table[i - begin][j - begin] = result;
                table[j - begin][i - begin] = result;

            }
        }
    }

    /**
     * Format and print border and output for the table
     */
    public void printTable() {
        if (table == null) {
            System.err.println("There is no table to print!");
            return;
        }

        if (tableType == TableType.MULT) {
            System.out.print("    *");
        } else if (tableType == TableType.ADD) {
            System.out.print("    +");
        }

        for (int i = start; i <= end; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();
        System.out.println("     " + "-".repeat(5 * table.length));

        for (int i = 0; i < table.length; i++) {
            System.out.printf("%3d", i + start);
            System.out.print(" |");
            for (int j = 0; j < table.length; j++) {
                System.out.printf("%5d", (int)table[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        ArithmeticTable table = new ArithmeticTable();
        if (table.argumentCheck(args)){
            table.createTable(table.start, table.end, table.tableType);
            table.printTable();
        }

    }
}