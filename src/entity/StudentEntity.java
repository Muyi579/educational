package entity;

/**
 * @author 学生实体类
 *
 */
public class StudentEntity {

	private String studentNo; // 学生编号
	private String studentName; // 学生姓名
	private String gender; // 学生性别
	private String birthday; // 出生日期
	private String password; // 学生密码
	private Integer status; // 状态
	private ClassEntity classEntity; // 关联班级实体类得到班级编号

	public StudentEntity() {
		super();
	}

	public StudentEntity(String studentNo, String studentName, String gender, String birthday, String password,
						 Integer status) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.gender = gender;
		this.birthday = birthday;
		this.password = password;
		this.status = status;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StudentEntity [studentNo=" + studentNo + ", studentName=" + studentName + ", gender=" + gender
				+ ", birthday=" + birthday + ", password=" + password + ", status=" + status + ", ClassEntity="
				+ classEntity + "]";
	}

}
