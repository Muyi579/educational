package service;

import dao.TeacherDaoImpl;
import entity.TeacherEntity;

public class TeacherServiceImpl implements TeacherService {

	TeacherDaoImpl teacher = new TeacherDaoImpl();

	@Override
	public TeacherEntity teacherinfo(String teactherNo, String password) {
		return teacher.teacherEntityinfo(teactherNo, password);
	}

	@Override
	public boolean updateTeacherInfo(String teacherNo, String password) {

		return teacher.teacherUpdate(teacherNo, password);
	}

}
