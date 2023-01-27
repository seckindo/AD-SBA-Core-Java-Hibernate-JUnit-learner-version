package sba.sms.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sba.sms.models.Course;
import sba.sms.utils.CommandLine;
import sba.sms.utils.HibernateUtil;

class CourseServiceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Test Started");
		HibernateUtil.getSessionFactory().openSession();
		CommandLine.addData();
	}

	@Test @DisplayName("testing courses")
	void test() {
		//fail("Not yet implemented");
		
		 CourseService courseService = new CourseService();
	     String instructorPhillip = "Phillip Witkin";
        
        List<Course> expected = new ArrayList<>(Arrays.asList(
                new Course(1,"Java", instructorPhillip),
                new Course(2, "Frontend", "Kasper Kain"),
                new Course(3, "JPA", "Jafer Alhaboubi"),
                new Course(4, "Spring Framework", instructorPhillip),
                new Course(5, "SQL", instructorPhillip)
        ));
        
        assertThat(courseService.getAllCourses()).hasSameElementsAs(expected);
        
	}

}
