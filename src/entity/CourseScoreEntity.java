package entity;

/**
 * @author 课程成绩表
 *
 */
public class CourseScoreEntity {

	private StudentEntity studentEntity; // 关联学生表得到学生编号
	private CourseEntity courseEntity; // 关联课程表得到课程编号
	private String score; // 学生成绩

	public CourseScoreEntity() {
		super();
	}

	public CourseScoreEntity(String score) {
		super();
		this.score = score;
	}

	public StudentEntity getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}

	public CourseEntity getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "CourseScoreEntity [StudentEntity=" + studentEntity + ", CourseEntity=" + courseEntity + ", score="
				+ score + "]";
	}

}
