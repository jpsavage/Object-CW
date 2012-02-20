import java.util.*;
//comment

class Table
{
    
    private String table_name;
    private String [] table_columns;
    private ArrayList<Record> records;
    
    Table(String name, String[] columns)
    {
        if (name.equals(null) || (columns.length == 0))
        {
            throw new Error("Error: table name and/or records not given\n");
        }
        table_name = name;
        table_columns = columns;
        records = new ArrayList<Record>();
    }
    
    int column(String name)
    {
        int l = table_columns.length;
        for(int i = 0; i < l; i++)
        {
            if(table_columns[i].equals(name))
            {
                return i;
            }
            else if( i == (l - 1))
            {
                throw new Error("No column with that name");
            }
        }
        return 0;
    }
    
    int columns()
    {
        return table_columns.length;
    }
    
    void delete(Record r)
    {
        try
        {
            records.remove(r);
        }
        catch(Exception e)
        {
            throw new Error("No record by that name");
        }
    }
    
    void insert(Record r)
    {
        records.add(r);
    }
    
    String name()
    {
        return table_name;
    }
    
    String name(int col)
    {
        if((col < 0 )||(col > (table_columns.length - 1)))
        {
            throw new Error("column index out of range");
        }
        return table_columns[col];
    }
    
    int rows()
    {
            return records.size();
    }
    
    Record select(int row)
    {
        if((row < 0 )||(row > (records.size() - 1)))
        {
            throw new Error("row index out of range");
        }
        return records.get(row);
    }
    
    public static void main(String[] args)
    {
        String[] testRecords = {"a","b","c"};
        Table testTable = new Table("TestTable", testRecords);
        if (testTable.column("a") != 0)
        {
            System.err.println("Error in column(String)");
            System.exit(1);
        }
        if (testTable.columns() != 3)
        {
            System.err.println("Error in columns()");
            System.exit(1);
        }
        
        String[] testData = {"d","e","f"};
        Record testRecord1 = new Record(testData);
        Record testRecord2 = new Record(testData);
        Record testRecord3 = new Record(testData);
        testTable.insert(testRecord1);
        testTable.insert(testRecord2);
        testTable.insert(testRecord3);
        
        if (testTable.rows() != 3)
        {
            System.err.println("Error in rows()");
            System.exit(1);
        }
        testTable.delete(testRecord1);
        if (testTable.rows() != 2)
        {
            System.err.println("Error in delete(Record)");
            System.exit(1);
        }
        if (!(testTable.name().equals("TestTable")))
        {
            System.err.println("Error in name()");
            System.exit(1);
        }
        if (!(testTable.name(0).equals("a")))
        {
            System.err.println("Error in name(int)");
            System.exit(1);
        }
        if (!(testTable.select(0).equals(testRecord2)))
        {
            System.err.println("Error in select(int)");
            System.exit(1);
        }
    }
      
}
