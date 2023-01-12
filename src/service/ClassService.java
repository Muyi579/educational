package service;

import entity.ClassEntity;

import java.util.List;
import java.util.Map;

public interface ClassService {

	/**
	 * @param className
	 * @return根据班级名获取班级编号
	 */
	String classnum(String className);

	/**
	 * @return 获取班级名
	 */
	List<String> classAll();

	/**
	 * @return 获取班级信息
	 */
	List<ClassEntity> getClassinfo();

	/**
	 * @param paream
	 * @return获取班级学生信息
	 */
	List<Map<String, Object>> getStudentClassAll(Map<String, Object> paream);

	/**
	 * @return所有班级所有学生
	 */
	List<Map<String, String>> getStuAllClassAll();

	/**
	 * @param classEntity
	 * @return添加班级
	 */
	boolean addclass(ClassEntity classEntity);

	/**
	 * @param classEntity
	 * @return 修改班级信息
	 */
	boolean updateclass(ClassEntity classEntity);

	/**
	 * @param classNo
	 * @return 根据编号删除班级
	 */
	boolean deleteclass(String classNo, String className);

	/**
	 * @param classNo
	 * @return判断班级是否存在
	 */
	List<String> judgeclass();

	/**
	 * @param classNo
	 * @return 查询班级是否有学生
	 */
	boolean getstudentclass(String classNo);

	/**
	 * @param studentNo
	 * @param classNo
	 * @return根据编号修改学生班级
	 */
	boolean updatestudentclass(String studentNo, String classNo);
}
