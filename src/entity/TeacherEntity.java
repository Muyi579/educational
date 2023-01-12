package entity;

/**
 * @author 教师实体类
 *
 */
public class TeacherEntity {

	private String teacherNo; // 教师编号
	private String teacherName; // 教师姓名
	private String password; // 密码

	public TeacherEntity() {
		super();
	}

	public TeacherEntity(String teacherNo, String teacherName, String password) {
		super();
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.password = password;

	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "TeacherEntity [teacherNo=" + teacherNo + ", teacherName=" + teacherName + ", password=" + password
				+ "]";
	}

}
