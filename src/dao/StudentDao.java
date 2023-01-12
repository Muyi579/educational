package dao;

import entity.StudentEntity;

import java.util.List;
import java.util.Map;

public interface StudentDao {

	/**
	 * @param 获取学生信息根据密码学号
	 * @return 返回学生信息
	 */
	List<Map<Object, Object>> studentlogin(String stuNo, String pd);

	/**
	 * @param pw
	 * @return 根据学号原密码修改密码
	 */
	boolean studenPassWordUpdate(String studNo, String password);

	/**
	 * @param 根据传进来信息得到
	 *            全部学生信息/按学号查询学生信息/按学生姓名查询学生信息
	 * @return
	 */
	List<Map<String, Object>> getStudentinfo(Map<String, Object> params);

	/**
	 * @param params
	 * @return 添加学生
	 */
	boolean addStu(StudentEntity student);

	/**
	 * @param studentNo
	 * @return根据编号修改学生状态
	 */
	boolean updateStu(String studentNo);

	/**
	 * @param params
	 * @return 修改学生信息
	 */
	boolean updatestudentAll(Map<String, Object> params);

	/**
	 * @param no
	 * @return 查询是否有该学生
	 */
	List<String> getStudentNum();

	/**
	 * @return查询每个班级多少人
	 */
	List<Map<String, String>> classStudent();

}
