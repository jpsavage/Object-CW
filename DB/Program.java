class Program
{
    public static void main(String[] args)
    {
        Program program = new Program();
        program.run();
    }

    void run()
    {
        String[] values = new String[] {"red", "blue", "green"};
        Record record = new Record(values);
        int f = record.fields();
        System.out.println("Number of fields (should be 3): " + f);
        System.out.println("Field 1 (should be blue): " + record.field(1));
        record.field(1, "yellow");
        System.out.println("Field 1 (should be yellow): " + record.field(1));
        try
        {
            String s = record.field(-1);
            System.out.println("The program shouldn't reach this point.");
        }
        catch (Error err)
        {
            String m = err.getMessage();
            System.out.println("Error (should be 'Bad column.'): " + m);
        }
    }
}
