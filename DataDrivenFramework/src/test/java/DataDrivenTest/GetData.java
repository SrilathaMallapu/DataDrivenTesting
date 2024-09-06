package DataDrivenTest;

import org.testng.annotations.DataProvider;

public class GetData {
	@DataProvider(name="getdata",indices={1})
	public  String[][] supplyData() {
		String [][] data= {{"werwerw","1234"},{"Hasni@gmail.com","Hasini@96"},{"werwer","34r45"}};
		
			return data;	
		}
}
