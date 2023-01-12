package dao;

import dbut.DBUtil;
import entity.StudentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {

	/**
	 * @author
	 * @return根据编号密码获取学生信息
	 */
	@Override
	public List<Map<Object, Object>> studentlogin(String stuNo, String pd) {
		ResultSet rs = DBUtil.doQuery(
				"select A.student_no,A.student_name,A.gender,A.birthday,A.password,A.status,C.credlit,D.class_no,D.class_name,C.course_no,C.course_name,B.score from student A left join course_score B on A.student_no = B.student_no inner join course C on B.course_no = C.course_no inner join class D on A.class_no = D.class_no where A.student_no = ? and A.password = ? and B.score is not null",
				stuNo, pd);
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();

		try {
			while (rs.next()) {
				Map<Object, Object> map = new HashMap<Object, Object>();
				String studentNo = rs.getString("student_no");
				String studentName = rs.getString("student_name");
				String gender = rs.getString("gender");
				String birthday = rs.getString("birthday");
				String password = rs.getString("password");
				Integer status = rs.getInt("status");
				Float credlit = rs.getFloat("credlit");
				String classNo = rs.getString("class_no");
				String className = rs.getString("class_name");
				String courseNo = rs.getString("course_no");
				String courseName = rs.getString("course_name");
				Float score = rs.getFloat("score");
				map.put("studentNo", studentNo);
				map.put("studentName", studentName);
				map.put("gender", gender);
				map.put("birthday", birthday);
				map.put("password", password);
				map.put("status", status);
				map.put("classNo", classNo);
				map.put("className", className);
				map.put("courseNo", courseNo);
				map.put("courseName", courseName);
				map.put("score", score);
				map.put("credlit", credlit);
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @author
	 * @return根据学号密码修改学生密码
	 */
	@Override
	public boolean studenPassWordUpdate(String studNo, String password) {
		int doUpdate = DBUtil.doUpdate("update student set password = ? where student_no = ?", password, studNo);
		return doUpdate > 0 ? true : false;
	}

	@Override
	public List<Map<String, Object>> getStudentinfo(Map<String, Object> params) {
		List<Map<String, Object>> list = new ArrayList<>();
		ResultSet rs = null;
		if (params.get("按全文搜索") != null) {
			rs = DBUtil.doQuery(
					"select A.student_no,A.student_name,A.gender,A.birthday,B.class_no,B.class_name,A.status from student A left join class B on A.class_no = B.class_no ");
		} else if (params.get("按学号搜索") != null) {
			rs = DBUtil.doQuery(
					"select A.student_no,A.student_name,A.gender,A.birthday,B.class_no,B.class_name,A.status from student A left join class B on A.class_no = B.class_no where A.student_no = ?",
					params.get("stuNo"));
		} else if (params.get("按学生姓名搜索") != null) {
			rs = DBUtil.doQuery(
					"select A.student_no,A.student_name,A.gender,A.birthday,B.class_no,B.class_name,A.status from student A left join class B on A.class_no = B.class_no where A.student_name = ?",
					params.get("stuName"));
		}
		try {
			while (rs.next()) {
				String studentNo = rs.getString("student_no");
				String studentName = rs.getString("student_name");
				String gender = rs.getString("gender");
				String birthday = rs.getString("birthday");
				String classNo = rs.getString("class_no");
				String className = rs.getString("class_name");
				Integer status = rs.getInt("status");
				Map<String, Object> map = new HashMap<>();
				map.put("studentNo", studentNo);
				map.put("studentName", studentName);
				map.put("gender", gender);
				map.put("birthday", birthday);
				map.put("classNo", classNo);
				map.put("className", className);
				if (status == 0) {
					map.put("status", "在读");
				} else {
					map.put("status", "休学");
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addStu(StudentEntity student) {
		int rs = DBUtil.doUpdate("insert into student values(?,?,?,?,?,?,?)", student.getStudentNo(),
				student.getStudentName(), student.getGender(), student.getBirthday(), student.getPassword(),
				student.getStatus(), student.getClassEntity().getClassNo());
		return rs > 0 ? true : false;
	}

	@Override
	public boolean updateStu(String studentNo) {
		int rs = DBUtil.doUpdate("update student set status = 1 where student_no = ?", studentNo);
		return rs > 0 ? true : false;
	}

	@Override
	public boolean updatestudentAll(Map<String, Object> params) {
		int rs = DBUtil.doUpdate(
				"update student set student_name = ?,gender = ?, birthday = ? ,password = ? ,status = ? , class_no = ? where student_no = ?",
				params.get("stuName"), params.get("gender"), params.get("birthday"), params.get("password"),
				params.get("status"), params.get("classNo"), params.get("studentNo"));
		return rs > 0 ? true : false;
	}

	@Override
	public List<String> getStudentNum() {
		List<String> list = new ArrayList<>();
		ResultSet rs = DBUtil.doQuery("select student_no from student");
		try {
			while (rs.next()) {
				String studentNo = rs.getString("student_no");
				list.add(studentNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, String>> classStudent() {
		List<Map<String, String>> list = new ArrayList<>();
		ResultSet rs = DBUtil.doQuery(
				"select B.class_no , B.class_name,count(A.student_no) from student A right join class B on A.class_no = B.class_no group by B.class_no");
		try {
			while (rs.next()) {
				String classNo = rs.getString("class_no");
				String className = rs.getString("class_name");
				String count = rs.getString("count(A.student_no)");
				Map<String, String> map = new HashMap<>();
				map.put("classNo", classNo);
				map.put("className", className);
				map.put("count", count);
				list.add(map);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
