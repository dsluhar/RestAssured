package api.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderLogin2 {

	@DataProvider(name = "LoginData")
	public Object[][] testLogin(Method m)
	{
	Object [][] testdata =null;
	
	if (m.getName().equals("TestPrint"))
	{
		testdata = new Object[][]
				{
					{"DLFi3", "Fiadmin", "P@assword1"},
					{"DLFi1", "Fiadmin", "P@assword2"},
					{"DLFi4", "Fiadmin", "P@assword4"}
				};
	}
		return testdata;
	}
}
