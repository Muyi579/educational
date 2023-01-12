package dao;

import dbut.DBUtil;
import entity.ClassEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassDaoImpl implements ClassDao {

	@Override
	public String classno(String className) {
		String count = "";
		ResultSet rs = DBUtil.doQuery("select class_no from class where class_name = ?", className);
		try {
			while (rs.next()) {
				count = rs.getString("class_no");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<String> classAll() {
		List<String> list = new ArrayList<String>();
		ResultSet rs = DBUtil.doQuery("select class_name from class");
		try {
			while (rs.next()) {
				String className = rs.getString("class_name");
				list.add(className);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ClassEntity> getclassAll() {
		List<ClassEntity> list = new ArrayList<>();
		ClassEntity classEntity = null;
		ResultSet rs = DBUtil.doQuery("select class_no , class_name from class");
		try {
			while (rs.next()) {
				String classNo = rs.getString("class_no");
				String className = rs.getString("class_name");
				classEntity = new ClassEntity(classNo, className);
				list.add(classEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getStudentClass(Map<String, Object> map) {
		List<Map<String, Object>> list = new ArrayList<>();
		ResultSet rs = null;
		if (map.get("className") != null) {
			rs = DBUtil.doQuery(
					"select A.student_no , A.student_name , B.class_no , B.class_name from student A left join class B on A.class_no = B.class_no where B.class_name = ?",
					map.get("className"));
		}
		try {
			while (rs.next()) {
				String studentNo = rs.getString("student_no");
				String studentName = rs.getString("student_name");
				String classNo = rs.getString("class_no");
				String className = rs.getString("class_name");
				Map<String, Object> map2 = new HashMap<String, Object>();
				map2.put("studentNo", studentNo);
				map2.put("studentName", studentName);
				map2.put("classNo", classNo);
				map2.put("className", className);
				list.add(map2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, String>> getStuAllClass() {
		List<Map<String, String>> list = new ArrayList<>();
		ResultSet rs = DBUtil.doQuery(
				"select A.student_no ,A.student_name,B.class_no,B.class_name from student A left join class B on A. class_no = B.class_no");
		try {
			while (rs.next()) {
				String studentNo = rs.getString("student_no");
				String studentName = rs.getString("student_name");
				String classNo = rs.getString("class_no");
				String calssName = rs.getString("class_name");
				Map<String, String> map = new HashMap<>();
				map.put("studentNo", studentNo);
				map.put("studentName", studentName);
				map.put("classNo", classNo);
				map.put("className", calssName);
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addclass(ClassEntity classEntity) {
		int rs = DBUtil.doUpdate("insert into class values(?,?)", classEntity.getClassNo(), classEntity.getClassName());
		return rs > 0 ? true : false;
	}

	@Override
	public boolean updateclass(ClassEntity classEntity) {
		int rs = DBUtil.doUpdate("update class set class_name = ? where class_no = ?", classEntity.getClassName(),
				classEntity.getClassNo());
		return rs > 0 ? true : false;
	}

	@Override
	public boolean deleteclass(String classNo, String className) {
		int rs = DBUtil.doUpdate("delete from class where class_no = ? and class_name = ?", classNo, className);
		return rs > 0 ? true : false;
	}

	@Override
	public List<String> judgeclass() {
		List<String> list = new ArrayList<>();
		ResultSet rs = DBUtil.doQuery("select class_no from class");
		try {
			while (rs.next()) {
				String classNo = rs.getString("class_no");
				list.add(classNo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean getstudentclass(String classNo) {
		ResultSet rs = DBUtil.doQuery("select class_no from student where class_no = ?", classNo);

		try {
			if (rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean updatestudentclass(String studentNo, String classNo) {
		int rs = DBUtil.doUpdate("update student set class_no = ? where student_no = ?", classNo, studentNo);
		return rs > 0 ? true : false;
	}

}
