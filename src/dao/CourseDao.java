package dao;

import java.util.List;
import java.util.Map;

/**
 * @author 课程dao层类
 *
 */
public interface CourseDao {

	/**
	 * @return查询所有课程
	 */
	List<String> getcourseAll();

	/**
	 * @param studentName
	 * @return根据课程名查询课程编号
	 */
	String getCourseName(String studentName);

	/**
	 * @return 根据传入条件获取信息
	 */
	List<Map<String, Object>> getcoursestudents(Map<String, Object> parame);

	/**
	 * @return获取课程名，选课人数
	 */
	List<Map<String, Object>> getcourseinfo();

	/**
	 * @param courseNo
	 * @param courseName
	 * @return添加课程
	 */
	boolean addcourse(String courseNo, String courseName);

	/**
	 * @param courseNo
	 * @return 删除课程
	 */
	boolean deletecourse(String courseNo);

	/**
	 * @param courseName
	 * @param courseNo
	 * @return 修改课程
	 */
	boolean updatecourse(String courseName, String courseNo);

	/**
	 * 
	 * @return 获取所有编号
	 */
	List<String> getcourseNo();

	/**
	 * @param courseNo
	 * @return 查询课程下是否有人
	 */
	boolean getcountcourse(String courseNo);

	/**
	 * @param courseNo
	 * @return 根据编号获取学生信息
	 */
	List<Map<String, Object>> getstudentInfo(String courseNo);

	/**
	 * @param courseName
	 * @return 根据传进来名字修改学生选择课程
	 */
	boolean updatestudentcourse(String courseName, String courseNo);

	/**
	 * @param studentNo
	 * @return 获取没有报的科目
	 */
	List<String> get(String studentNo);

}
