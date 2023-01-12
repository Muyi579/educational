package service;

import java.util.List;
import java.util.Map;

/**
 * @author 分数业务接口
 *
 */
public interface CourseScoreService {

	/**
	 * @param paream
	 * @return 获取信息，根据课程
	 */
	List<Map<String, Object>> getscore(Map<String, Object> paream);

	/**
	 * @param studentNo
	 * @return 根据学号判断成绩是否为空；
	 */
	boolean getscore(String studentNo, String courseNo);

	/**
	 * @param studentNo
	 * @return添加成绩
	 */
	boolean updateScoreNo(String score, String studentNo, String courseNo);

	/**
	 * @param studentNo
	 * @return根据编号查课程为空的课程
	 */
	String getCourseNameNo(String studentNo);

	/**
	 * @param studentNo
	 * @return 根据编号获取学生所报科目编号
	 */
	List<String> getstudentcourseName(String studentNo);
}
