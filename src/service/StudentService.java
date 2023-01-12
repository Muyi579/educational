package service;

import entity.StudentEntity;

import java.util.List;
import java.util.Map;

public interface StudentService {

	/**
	 * @param studentNo按照学生编号获取密码
	 * @return 返回密码
	 */
	List<Map<Object, Object>> studententry(String stuNo, String pw);

	/**
	 * @param pw
	 * @return 根据学号原密码修改密码
	 */
	boolean stuPassWordUpdate(String studNo, String password);

	/**
	 * @param 根据传进来信息得到
	 *            全部学生信息/按学号查询学生信息/按学生姓名查询学生信息
	 * @return
	 */
	List<Map<String, Object>> getStudent(Map<String, Object> params);

	/**
	 * @param params
	 * @return 添加学生
	 */
	boolean addStudent(StudentEntity student);

	/**
	 * @param studentNo
	 * @param status
	 * @return 修改学生状态
	 */
	boolean updatestudent(String studentNo);

	/**
	 * @param parame
	 * @return 修改学生信息
	 */
	boolean updatestudentAll(Map<String, Object> parame);

	/**
	 * @param no
	 * @return 查询是否有该学生
	 */
	List<String> getStudentNo();

	/**
	 * @return查询每个班级的学生
	 */
	List<Map<String, String>> getcounystudent();

}
