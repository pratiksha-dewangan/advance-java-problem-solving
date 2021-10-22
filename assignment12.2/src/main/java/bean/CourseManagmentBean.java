package bean;

import java.time.LocalDate;
import java.util.List;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

public class CourseManagmentBean {

	private CourseDaoImpl cdao;
	private StudentDaoImpl sdao;
	private String title;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	private String mesg;
	
	public CourseManagmentBean() {
		System.out.println("in CourseManagmentBean");
		this.cdao = new CourseDaoImpl();
		sdao=new StudentDaoImpl();
	}
	
	public String getMesg() {
		return mesg;
	}


	public void setMesg(String mesg) {
		this.mesg = mesg;
	}


	
	
	
	public List<String> fetchCourseTitle(){
		return cdao.getCourseTitles();
	}
	
	
	public String admitStudent(String name,String mail,String cgpa,String dob) {
		System.out.println("in admit student");
		if(LocalDate.now().isBefore(LocalDate.parse(dob)))
		{
			mesg="Invalid Date of Birth";
			return "admit";
		}
		if(Integer.parseInt(cgpa)<=0 || Integer.parseInt(cgpa)>10) {
			mesg="Invalid CPGA";
			return "admit";
		}
		
		if(sdao.admitNewStudent(new Student(name, mail), title).equals("success")) {
			mesg="Student Admitted Successfully";
			return "courses";
		}
		return "admit";
	}
	
	
	public String deleteCourse() {
		if(cdao.cancelCourseByName(title).equals("success")) {
			mesg="Course Deleted Successfully";
			return "courses";
		}
		
		mesg="Course Deletion Failed";
		return "courses";
	}
	
	
	public Course courseDetails() {
		return cdao.getCourseStudentDetailsJoinQuery(title);
	}
}
