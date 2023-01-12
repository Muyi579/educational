package service;

import dao.CourseScoreDaoImpl;

import java.util.List;
import java.util.Map;

/**
 * @author 分数业务实现类
 *
 */
public class CourseScoreServiceImpl implements CourseScoreService {

	CourseScoreDaoImpl courseScoreDaoImpl = new CourseScoreDaoImpl();

	@Override
	public List<Map<String, Object>> getscore(Map<String, Object> paream) {
		return courseScoreDaoImpl.getstudentScore(paream);
	}

	@Override
	public boolean getscore(String studentNo, String courseNo) {
		// TODO Auto-generated method stub
		return courseScoreDaoImpl.getscorenull(studentNo, courseNo);
	}

	@Override
	public boolean updateScoreNo(String score, String studentNo, String courseNo) {
		// TODO Auto-generated method stub
		return courseScoreDaoImpl.updateScore(score, studentNo, courseNo);
	}

	@Override
	public String getCourseNameNo(String studentNo) {
		// TODO Auto-generated method stub
		return courseScoreDaoImpl.getCourseName(studentNo);
	}

	@Override
	public List<String> getstudentcourseName(String studentNo) {
		// TODO Auto-generated method stub
		return courseScoreDaoImpl.getNocourseName(studentNo);
	}

}
