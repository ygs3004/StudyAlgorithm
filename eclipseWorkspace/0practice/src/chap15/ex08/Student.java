package chap15.ex08;

public class Student {

	public int studentNum;
	public String name;
	
	public Student(int studentNum, String name) {
		this.studentNum=studentNum;
		this.name=name;
	}
	
	@Override
	public int hashCode() {
		return studentNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student st=(Student)obj;
			if(st.studentNum==this.studentNum)
				return true;
			return false;
		}return false;
	}
}
