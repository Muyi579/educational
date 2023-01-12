package service;

import entity.TeacherEntity;

public interface TeacherService {

	/**
	 * @param teactherNo
	 * @param password
	 * @return 根据编号密码获取老师信息
	 */
	TeacherEntity teacherinfo(String teactherNo, String password);

	/**
	 * @param teacherNo
	 * @return修改密码
	 */
	boolean updateTeacherInfo(String teacherNo, String password);

}
