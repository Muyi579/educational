package dao;

import dbut.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScoreDaoImpl implements CourseScoreDao {

	@Override
	public List<Map<String, Object>> getstudentScore(Map<String, Object> paream) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		ResultSet rs = null;
		if (paream.get("全部课程") != null && paream.get("全部班级") != null) { // 1、查所有
			rs = DBUtil.doQuery(
					"select A.student_no,A.student_name,C.class_name,D.course_name,B.score from student A left join course_score B on A.student_no = B.student_no inner join class C on A.class_no = C.class_no inner join course D on B.course_no = D.course_no");
		} else if (paream.get("课程加学号其他") != null) { // 5、学号+课程
			rs = DBUtil.doQuery(
					"select A.student_no,A.student_name,C.class_name,D.course_name,B.score from student A left join course_score B on A.student_no = B.student_no inner join class C on A.class_no = C.class_no inner join course D on B.course_no = D.course_no where A.student_no = ? and D.course_name = ?",
					paream.get("studentNo"), paream.get("courseName"));
		} else if (paream.get("班级其他") != null) { // 3、按照班级
			rs = DBUtil.doQuery(
					"select A.student_no,A.student_name,C.class_name,D.course_name,B.score from student A left join course_score B on A.student_no = B.student_no inner join class C on A.class_no = C.class_no inner join course D on B.course_no = D.course_no where C.class_name = ?",
					paream.get("className"));
		} else if (paream.get("课程其他") != null) { // 4、按照课程
			rs = DBUtil.doQuery(
					"select A.student_no,A.student_name,C.class_name,D.course_name,B.score from student A left join course_score B on A.student_no = B.student_no inner join class C on A.class_no = C.class_no inner join course D on B.course_no = D.course_no where D.course_name = ?",
					paream.get("courseName"));
		} else if (paream.get("班级加课程其他") != null) { // 6、班级+课程
			rs = DBUtil.doQuery(
					"select A.student_no,A.student_name,C.class_name,D.course_name,B.score from student A left join course_score B on A.student_no = B.student_no inner join class C on A.class_no = C.class_no inner join course D on B.course_no = D.course_no where C.class_name = ? and D.course_name = ?",
					paream.get("className"), paream.get("courseName"));
		} else if (paream.get("学号") != null) { // 2、按照学号
			rs = DBUtil.doQuery(
					"select A.student_no,A.student_name,C.class_name,D.course_name,B.score from student A left join course_score B on A.student_no = B.student_no inner join class C on A.class_no = C.class_no inner join course D on B.course_no = D.course_no where A.student_no = ?",
					paream.get("studentNo"));
		}

		try {
			while (rs.next()) {
				String studentNo = rs.getString("student_no");
				String studentName = rs.getString("student_name");
				String className = rs.getString("class_name");
				String courseName = rs.getString("course_name");
				float score = rs.getFloat("score");
				Map<String, Object> map = new HashMap<>();
				map.put("studentNo", studentNo);
				map.put("studentName", studentName);
				map.put("className", className);
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
	public boolean getscorenull(String studentNo, String courseNo) {
		ResultSet rs = DBUtil.doQuery(
				"select score from course_score  where student_no = ? and course_no = ? and score is null", studentNo,
				courseNo);
		try {
			while (rs.next()) {
				rs.getFloat("score");
				if (rs.wasNull()) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateScore(String score, String studentNo, String courseNo) {
		int rs = DBUtil.doUpdate("update course_score set score = ? where student_no = ? and course_no = ?", score,
				studentNo, courseNo);
		return rs > 0 ? true : false;
	}

	@Override
	public String getCourseName(String studentNo) {
		ResultSet rs = DBUtil.doQuery(
				"select B.course_name from course_score A left join course B on A.course_no = B.course_no  where student_no = ? and score is null",
				studentNo);
		String courseName = "";
		try {
			while (rs.next()) {
				courseName = rs.getString("course_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseName;
	}

	@Override
	public List<String> getNocourseName(String studentNo) {
		List<String> list = new ArrayList<>();
		ResultSet rs = DBUtil.doQuery("select course_no from course_score where student_no = ? ", studentNo);
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

}
