package service;

import dao.CourseDaoImpl;

import java.util.List;
import java.util.Map;

/**
 * @author 课程业务实现类
 *
 */
public class CourseServiceImpl implements CourseService {

	// 连接dao层课程实现类
	CourseDaoImpl course = new CourseDaoImpl();

	@Override
	public List<String> courseAll() {

		return course.getcourseAll();
	}

	@Override
	public String getCourseNo(String courseName) {
		// TODO Auto-generated method stub
		return course.getCourseName(courseName);
	}

	@Override
	public List<Map<String, Object>> getcourse(Map<String, Object> parame) {
		// TODO Auto-generated method stub
		return course.getcoursestudents(parame);
	}

	@Override
	public List<Map<String, Object>> getcourseInfo() {
		// TODO Auto-generated method stub
		return course.getcourseinfo();
	}

	@Override
	public boolean addcourse(String courseNo, String courseName) {
		// TODO Auto-generated method stub
		return course.addcourse(courseNo, courseName);
	}

	@Override
	public boolean deletecourse(String courseNo) {
		// TODO Auto-generated method stub
		return course.deletecourse(courseNo);
	}

	@Override
	public boolean updatecourse(String courseName, String courseNo) {
		// TODO Auto-generated method stub
		return course.updatecourse(courseName, courseNo);
	}

	@Override
	public List<String> getcourseNo() {
		// TODO Auto-generated method stub
		return course.getcourseNo();
	}

	@Override
	public boolean getcountcourse(String courseNo) {
		// TODO Auto-generated method stub
		return course.getcountcourse(courseNo);
	}

	@Override
	public List<Map<String, Object>> getstudentInfo(String courseNo) {
		// TODO Auto-generated method stub
		return course.getstudentInfo(courseNo);
	}

	@Override
	public boolean updatestudentcourse(String courseName, String courseNo) {
		// TODO Auto-generated method stub
		return course.updatestudentcourse(courseName, courseNo);
	}

	@Override
	public List<String> get(String studentNo) {
		// TODO Auto-generated method stub
		return course.get(studentNo);
	}

}
