package service;

import dao.StudentDaoImpl;
import entity.StudentEntity;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {

	StudentDaoImpl studaoimpl = new StudentDaoImpl();

	@Override
	public List<Map<Object, Object>> studententry(String stuNo, String pw) {

		return studaoimpl.studentlogin(stuNo, pw);
	}

	@Override
	public boolean stuPassWordUpdate(String studNo, String password) {

		return studaoimpl.studenPassWordUpdate(studNo, password);
	}

	@Override
	public List<Map<String, Object>> getStudent(Map<String, Object> params) {

		return studaoimpl.getStudentinfo(params);
	}

	@Override
	public boolean addStudent(StudentEntity student) {
		return studaoimpl.addStu(student);
	}

	@Override
	public boolean updatestudent(String studentNo) {
		return studaoimpl.updateStu(studentNo);
	}

	@Override
	public boolean updatestudentAll(Map<String, Object> parame) {

		return studaoimpl.updatestudentAll(parame);
	}

	@Override
	public List<String> getStudentNo() {
		return studaoimpl.getStudentNum();
	}

	@Override
	public List<Map<String, String>> getcounystudent() {
		// TODO Auto-generated method stub
		return studaoimpl.classStudent();
	}

}
