package dao;

import dbut.DBUtil;
import entity.TeacherEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public TeacherEntity teacherEntityinfo(String teactherEntityNo, String teactherEntitypassword) {
		TeacherEntity teacher = null;
		ResultSet rs = DBUtil.doQuery(
				"select teacher_no , teacher_name,password from teacher where teacher_no = ? and password = ?",
				teactherEntityNo, teactherEntitypassword);
		try {
			while (rs.next()) {
				String teacherNo = rs.getString("teacher_no");
				String teacherName = rs.getString("teacher_name");
				String password = rs.getString("password");
				teacher = new TeacherEntity(teacherNo, teacherName, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public boolean teacherUpdate(String teacherNo, String password) {
		int rs = DBUtil.doUpdate("update teacher set password = ? where teacher_no = ?", password, teacherNo);
		return rs > 0 ? true : false;
	}

}
