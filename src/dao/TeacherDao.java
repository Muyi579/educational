package dao;

import entity.TeacherEntity;

public interface TeacherDao {

	/**
	 * @param teactherNo
	 * @param password
	 * @return根据工号密码获取教师信息
	 */
	TeacherEntity teacherEntityinfo(String teactherNo, String password);

	/**
	 * @param teacherNo
	 * @return 修改密码
	 */
	boolean teacherUpdate(String teacherNo, String password);
}
