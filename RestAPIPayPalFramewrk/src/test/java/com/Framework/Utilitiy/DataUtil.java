package com.Framework.Utilitiy;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.Frameworksetup.BaseClassTest;

public class DataUtil extends BaseClassTest {

	
    //DataProvider method must be static when it is defined outside @Test Class
	//mention parallel=true for executing DataProvider test Parallel
	
	
	@DataProvider(name="testdata",parallel=true)
	public static Object[][] getdata(Method m) {
		
    ExcelReader excel=new ExcelReader("./src/test/resources/Excel/StripeTestData.xlsx");
	
	String testsheetName=config.getProperty("testdata_sheetName");
	
	int totalrows=excel.getRowCount(testsheetName);
	
	String expectedtestcaseName=m.getName();
	
	// any TestCase name should always start from at-least Rownum=1 and column should be always first column i.e 0th column(constant for testcase name)
	int testcaseStartRownum=1;
	
	//finding the starting row no of desired testcaseName 
	
	for(testcaseStartRownum=1;testcaseStartRownum<=totalrows;testcaseStartRownum++) {
		
		String testcaseName=excel.getCellData(testsheetName, 0, testcaseStartRownum);
		
		 if(testcaseName.equalsIgnoreCase(expectedtestcaseName)) {
			break;
		}
		
	}
	
	System.out.println("Testcase starts from row no : "+testcaseStartRownum);
	
	//finding the total no of test-data rows(excluding the column Header) inside a TestCase
	
	int testdataStartrowno=testcaseStartRownum+2;
	int testdatarowno=0;
	
	// it is followed here a blank line between two test case
	while(!excel.getCellData(testsheetName, 0, (testdataStartrowno+testdatarowno)).equals("")){
	
		testdatarowno++;
	
	}	
	
	System.out.println("Total no of TestData rows under Testcase are: "+testdatarowno);
	
  
	
  //finding the total no of column names inside a Test Case
	
  int testdataStartcolumnno=testcaseStartRownum+1;	
  int testdatacolumnno=0;
  
    while(!excel.getCellData(testsheetName, testdatacolumnno, testdataStartcolumnno).equals("")){
  
	  testdatacolumnno++;
	
     }

    
    System.out.println("Total no of Columns for the Test case are: "+testdatacolumnno);
    
    //traversing the test data
    // As we are using Hashtable and passing the same as argument in the main Test class so no of Data Provider column should be 1 
    
    Object[][] data =new Object[testdatarowno][1];
    
    int i=0;
    
    for(int rownum=testdataStartrowno; rownum<(testdataStartrowno+testdatarowno);rownum++)
    {
    	//for each test data row we are creating a Hash Table
    	
    	Hashtable<String,String> table=new Hashtable<String,String>();
    	
        for( int columno=0;columno<testdatacolumnno;columno++)
        {
        	//Data Provider should always starts with [0][0]
        	//data[rownum-testdataStartrowno][columno]=excel.getCellData(testsheetName,columno,rownum);
        	
        	String testdata=excel.getCellData(testsheetName,columno,rownum);
        	String colname=excel.getCellData(testsheetName, columno,testdataStartcolumnno );
        	table.put(colname, testdata);
        }
        
        data[i][0]=table;
        i++;
    
    }
    
    return data;
    
  }  
	
}