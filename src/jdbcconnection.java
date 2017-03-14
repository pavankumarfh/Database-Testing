import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class jdbcconnection {

public static void main(String[] args) throws SQLException, InterruptedException {
	  
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":" +port+ "/Qadbt", "root", "Thotamagi7");
        
		Statement s =con.createStatement();
		
		ResultSet rs =s.executeQuery("select * from Employeeinfo where name = 'pavan';");
		
		while (rs.next())
{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\pavan\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/?locale=de");
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("location"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("age"));
		driver.findElement(By.xpath(".//*[@id='Login']")).click();
		Thread.sleep(3000);
		String s1 = driver.findElement(By.xpath(".//*[@id='error']")).getText();
		System.out.println(s1);
		Thread.sleep(3000);
		driver.quit();
}
	}

}
