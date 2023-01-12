package service;

import dao.ClassDaoImpl;
import entity.ClassEntity;

import java.util.List;
import java.util.Map;

public class ClassServiceImpl implements ClassService {

	ClassDaoImpl classDaoImpl = new ClassDaoImpl();

	@Override
	public String classnum(String className) {
		// TODO Auto-generated method stub
		return classDaoImpl.classno(className);
	}

	@Override
	public List<String> classAll() {
		// TODO Auto-generated method stub
		return classDaoImpl.classAll();
	}

	@Override
	public List<ClassEntity> getClassinfo() {
		return classDaoImpl.getclassAll();
	}

	@Override
	public List<Map<String, Object>> getStudentClassAll(Map<String, Object> paream) {
		return classDaoImpl.getStudentClass(paream);
	}

	@Override
	public List<Map<String, String>> getStuAllClassAll() {
		// TODO Auto-generated method stub
		return classDaoImpl.getStuAllClass();
	}

	@Override
	public boolean addclass(ClassEntity classEntity) {
		// TODO Auto-generated method stub
		return classDaoImpl.addclass(classEntity);
	}

	@Override
	public boolean updateclass(ClassEntity classEntity) {
		// TODO Auto-generated method stub
		return classDaoImpl.updateclass(classEntity);
	}

	@Override
	public boolean deleteclass(String classNo, String className) {
		// TODO Auto-generated method stub
		return classDaoImpl.deleteclass(classNo, className);
	}

	@Override
	public List<String> judgeclass() {
		// TODO Auto-generated method stub
		return classDaoImpl.judgeclass();
	}

	@Override
	public boolean getstudentclass(String classNo) {
		// TODO Auto-generated method stub
		return classDaoImpl.getstudentclass(classNo);
	}

	@Override
	public boolean updatestudentclass(String studentNo, String classNo) {
		// TODO Auto-generated method stub
		return classDaoImpl.updatestudentclass(studentNo, classNo);
	}

}
