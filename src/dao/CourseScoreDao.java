package dao;

import java.util.List;
import java.util.Map;

/**
 * @author dao层分数接口
 *
 */
public interface CourseScoreDao {

	/**
	 * @param paream
	 * @return 获取信息，根据课程
	 */
	List<Map<String, Object>> getstudentScore(Map<String, Object> paream);

	/**
	 * @param studentNo
	 * @return 根据学号判断成绩是否为空；
	 */
	boolean getscorenull(String studentNo, String courseNo);

	/**
	 * @param studentNo
	 * @returnxiu成绩
	 */
	boolean updateScore(String score, String studentNo, String courseNo);

	/**
	 * @param studentNo
	 * @return根据编号查课程为空的课程
	 */
	String getCourseName(String studentNo);

	/**
	 * @param studentNo
	 * @return 根据编号获取学生所报科目编号
	 */
	List<String> getNocourseName(String studentNo);

}
