package com.cst438;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cst438.domain.Course;
import com.cst438.domain.CourseRepository;
import com.cst438.domain.Enrollment;
import com.cst438.domain.EnrollmentRepository;
import com.cst438.domain.Student;
import com.cst438.domain.StudentRepository;

@SpringBootTest
public class EndToEndAddStudent {

	public static final String CHROME_DRIVER_FILE_LOCATION = "/Users/aryanabuelna/Downloads/chromedriver_mac64/chromedriver.exe";

	public static final String URL = "http://localhost:3000";
	
	public static final int SLEEP_DURATION = 1000;

	public static final String TEST_STUDENT_EMAIL = "aryanabuelna@csumb.edu";

	public static final String TEST_STUDENT_NAME = "Aryana Buelna"; 


	@Autowired
	StudentRepository studentRepository;


	
	@Test
	public void addStudentTest() throws Exception {

		/*
		 * if student is already exists, then delete the student trying to be added.
		 */
		
		Student x = null;
		do {
			x = studentRepository.findByEmail(TEST_STUDENT_EMAIL);
			if (x != null)
				studentRepository.delete(x);
		} while (x != null);


		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FILE_LOCATION);
		WebDriver driver = new ChromeDriver();
		// Puts an Implicit wait for 10 seconds before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			driver.get(URL);
			Thread.sleep(SLEEP_DURATION);

			// Locate and click "Add student" button which is the first and only button on the page.
			driver.findElement(By.xpath("//button")).click();
			Thread.sleep(SLEEP_DURATION);

		} catch (Exception ex) {
			throw ex;
		} finally {

			// clean up database.
			Student e = studentRepository.findByEmail(TEST_STUDENT_EMAIL);
			if (e != null)
				studentRepository.delete(e);

			driver.quit();
		}

	}
}
