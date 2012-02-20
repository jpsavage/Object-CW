class Record
{
    private String[] data;
    
    Record(String[] values)
    {
        data = values;
    }
    
    /*constructor for testing only*/
    Record()
    {
    }
    
    /*returns the value in the given column number*/
    String field(int col)
    {
        if((col < 0) || (col > data.length - 1))
        {
            throw new Error("Bad column." );
        }
        String result = new String();
        result = data[col];
        return result;
    }
    
    /* changes the value of the given column to value */
    void field(int col, String value)
    {
        if((col < 0)||(col > (data.length - 1)))
        {
            throw new Error("Bad column." );
        }
        data[col] = value;
    }
    
    /*returns the number of columns in the record */
    int fields()
    {
        int result = data.length;
        return result;
    }
    
    public static void main(String[] args)
    {
        Record program = new Record();
        program.test();
        
    }
    
    void test()
    {
        test_field("red green blue orange pink yellow black grey purple");
        test_field1("red green blue orange pink yellow black grey purple");
        test_fields("red green blue orange pink yellow black grey purple",9);
    }
    void test_field(String data)
    {
        String[] values = data.split(" ");
        Record record = new Record(values);
        int l = values.length;
        for(int i = 0; i < l; i++)
        {
            if(!(record.field(i).equals(values[i])))
            {
                System.err.println("Error in field");
                System.exit(1);
            }
        }
    }
    
    void test_field1(String data)
    {
        String[] values = data.split(" ");
        Record record = new Record(values);
        int l = values.length;
        for(int i = 0; i < l; i++)
        {
            record.field(i,"test");
            if(!(record.field(i).equals("test")))
            {
                System.err.println("Error in field");
                System.exit(1);
            }
        }
    }
    
    void test_fields(String data, int expected)
    {
        String[] values = data.split(" ");
        Record record = new Record(values);
        if(record.fields() != expected)
        {
                System.err.println("Error in fields");
                System.exit(1);
        }
    }
            
}
