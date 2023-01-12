package entity;

/**
 * @author 班级实体类
 *
 */
public class ClassEntity {

	private String classNo; // 班级编号
	private String className; // 班级名

	public ClassEntity() {
		super();
	}

	public ClassEntity(String classNo, String className) {
		super();
		this.classNo = classNo;
		this.className = className;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "ClassEntity [classNo=" + classNo + ", className=" + className + "]";
	}

}
