/**
 * The driver program.  Displays the specified arithmetic table with
 * the specified start/stop values.
 *
 */
public final class Main {
    /**
     * Disallow the creation of any Main objects.
     */
    private Main() {
}

    /**
     * The entry point to the program.
     *
     * @param argv the command line args.
     *        argv[0] - the type (+ or *)
     *        argv[1] - the start value (> 1 && < 100)
     *        argv[2] - the end value (> 1 && < 100)
     */
    public static void main(final String[] argv) {
        final TableType type;
        final int start;
        final int stop;
		final Table table;
        
        if (argv.length != 3) {
            usage();
        }
        System.out.println(argv[0]);
        type  = getType(argv[0]);
        start = getNumber(argv[1]);
        stop  = getNumber(argv[2]);
        if (start > stop) {
            usage();
        }
        table = getTable(type, start, stop);
        table.display(type);
    }
    
    /**
     * Convert the supplied string into the appropriate TableType.
     * If the string is not a valid type then exit the program.
     *
     * @param str the string to convert
     * @return the appropriate TableType
     */
    public static TableType getType(final String str) {
        final TableType type;
        
        if(str.equals("+")) {
            type = TableType.ADD;
        } else if(str.equals("*")) {
            type = TableType.MULT;
        } else {
            usage();
            type = null;
        }
        return (type);
    }
    
    /**
     * Convert the supplied string into an int. 
     * If the string is not a valid int then exit the program.
     * To be valid the string must be an integer and be > 0 and < 100.
     *
     * @param str the string to convert
     * @return the converted number
     */
    public static int getNumber(final String str) {
        int val;
        
        try {
            val = Integer.parseInt(str);
            
            if(val < 1 || val > 100) {
                usage();
            }
        }
        catch(final NumberFormatException ex) {
            usage();
            val = 0;
        }
        return (val);
    }
    public static Table getTable(final TableType type, final int start, final int stop) {
        Table table = switch (type) {
            case ADD -> new AdditionTable(start, stop);
            case MULT -> new MultiplicationTable(start, stop);
        };
        table.calculateTable();
        return table;
    }

    /**
     * Display the usage message and exit the program.
     */
    public static void usage() {
        System.err.println("Usage: Main <type> <start> <stop>");
        System.err.println("\tWhere <type> is one of +, \"*\"");
        System.err.println("\tand <start> is between 1 and 100");
        System.err.println("\tand <stop> is between 1 and 100");
        System.err.println("\tand start < stop");
        System.exit(1);
    }
}
