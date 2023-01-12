package dao;

import dbut.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 课程dao层实现类
 *
 */
public class CourseDaoImpl implements CourseDao {

	@Override
	public List<String> getcourseAll() {
		List<String> list = new ArrayList<String>();
		ResultSet rs = DBUtil.doQuery("select course_name from course");
		try {
			while (rs.next()) {
				String courseName = rs.getString("course_name");
				list.add(courseName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getCourseName(String studentName) {
		String str = "";
		ResultSet rs = DBUtil.doQuery("select course_no from course where course_name = ?", studentName);
		try {
			while (rs.next()) {
				str = rs.getString("course_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public List<Map<String, Object>> getcoursestudents(Map<String, Object> parame) {
		List<Map<String, Object>> list = new ArrayList<>();
		ResultSet rs = null;
		if (parame.get("全部课程学生") != null) {
			rs = DBUtil.doQuery(
					"select C.student_no,C.student_name,A.course_no , A.course_name,B.score from course A left join course_score B on A.course_no = B.course_no left join student C on B.student_no = C.student_no ");
		}
		List<String> getcourseAll = getcourseAll(); // 得到课程名
		for (String string : getcourseAll) {
			if (parame.get(string) != null) {
				rs = DBUtil.doQuery(
						"select C.student_no,C.student_name,A.course_no , A.course_name,B.score from course A left join course_score B on A.course_no = B.course_no left join student C on B.student_no = C.student_no where A.course_name = ?",
						string);
			}
		}
		try {
			while (rs.next()) {
				String studentNo = rs.getString("student_no");
				String studentName = rs.getString("student_name");
				String courseNo = rs.getString("course_no");
				String courseName = rs.getString("course_name");
				String score = rs.getString("score");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("studentNo", studentNo);
				map.put("studentName", studentName);
				map.put("courseNo", courseNo);
				map.put("courseName", courseName);
				map.put("score", score);
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Map<String, Object>> getcourseinfo() {
		List<Map<String, Object>> list = new ArrayList<>();
		ResultSet rs = DBUtil.doQuery(
				"select A.course_no , A.course_name,count(C.student_no) from course A left join course_score B on A.course_no = B.course_no left join student C on B.student_no = C.student_no group by A.course_no");
		try {
			while (rs.next()) {
				String courseNo = rs.getString("course_no");
				String courseName = rs.getString("course_name");
				String count = rs.getString("count(C.student_no)");
				Map<String, Object> map = new HashMap<>();
				map.put("courseNo", courseNo);
				map.put("courseName", courseName);
				map.put("count", count);
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addcourse(String courseNo, String courseName) {
		int rs = DBUtil.doUpdate("insert into course (course_no,course_name) values(?,?)", courseNo, courseName);
		return rs > 0 ? true : false;
	}

	@Override
	public boolean deletecourse(String courseNo) {
		int rs = DBUtil.doUpdate("delete from course where course_no = ?", courseNo);
		return rs > 0 ? true : false;
	}

	@Override
	public boolean updatecourse(String courseName, String courseNo) {
		int rs = DBUtil.doUpdate("update course set course_name = ? where course_no = ?", courseName, courseNo);
		return rs > 0 ? true : false;
	}

	@Override
	public List<String> getcourseNo() {
		List<String> list = new ArrayList<>();
		ResultSet rs = DBUtil.doQuery("select course_no from course");
		try {
			while (rs.next()) {
				String courseNo = rs.getString("course_no");
				list.add(courseNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean getcountcourse(String courseNo) {
		ResultSet rs = DBUtil.doQuery("select B.student_no from course_score B  where B.course_no = ? ", courseNo);
		try {
			if (rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Map<String, Object>> getstudentInfo(String courseNo) {
		List<Map<String, Object>> list = new ArrayList<>();
		ResultSet rs = DBUtil.doQuery(
				"select C.student_no,C.student_name,A.course_name from course A left join course_score B on A.course_no = B.course_no left join student C on B.student_no = C.student_no where A.course_no = ?",
				courseNo);
		try {
			while (rs.next()) {
				String studentNo = rs.getString("student_no");
				String studentName = rs.getString("student_name");
				String courseName = rs.getString("course_name");
				Map<String, Object> map = new HashMap<>();
				map.put("studentNo", studentNo);
				map.put("studentName", studentName);
				map.put("courseName", courseName);
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updatestudentcourse(String courseName, String courseNo) {
		String courseNooo = getCourseName(courseName);
		int rs = DBUtil.doUpdate("update course_score set course_no = ? where course_no = ?", courseNooo, courseNo);

		return rs > 0 ? true : false;
	}

	@Override
	public List<String> get(String studentNo) {
		List<String> list = new ArrayList<>();
		ResultSet rs = DBUtil.doQuery(
				"select A.course_name FROM course A inner join course_score B on A.course_no = B.course_no where B.student_no = ?",
				studentNo);
		try {
			while (rs.next()) {
				String courseName = rs.getString("course_name");
				list.add(courseName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
