package entity;

/**
 * @author 课程表实现类
 *
 */
public class CourseEntity {

	private String courseNo; // 课程号
	private String courseName;// 课程名
	private float credit; // 学分

	public CourseEntity() {
		super();
	}

	public CourseEntity(String courseNo, String courseName, float credit) {
		super();
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.credit = credit;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "CourseEntity [courseNo=" + courseNo + ", courseName=" + courseName + ", credit=" + credit + "]";
	}

}
