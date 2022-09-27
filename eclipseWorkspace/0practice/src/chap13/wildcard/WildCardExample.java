package chap13.wildcard;

import java.util.Arrays;

public class WildCardExample {
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName()+"수강생:"+
							Arrays.toString(course.getStudents()));
	}

	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName()+"수강생:"+
							Arrays.toString(course.getStudents()));
	} // Course<? extends Student> course => Student 클래스와 Student를 상속받는 Student
	
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName()+"수강생:"+
							Arrays.toString(course.getStudents()));
	} // Course<? super Worker> course => Worker 클래스와 Worker의 부모클래스
	
	public static void main(String[] args) {
		Course<Person> personCourse=new Course<Person>("일반인과정",5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		
		Course<Worker> workerCourse = new Course<Worker>("직장인과정",5);
		workerCourse.add(new Worker("직장인"));
		
		Course<Student> studentCourse = new Course<Student>("학생",5);
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));
		
		Course<HighStudent> highStudentCourse = new Course<HighStudent>("고등학생과정",5);
		highStudentCourse.add(new HighStudent("고등학생"));
		
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);
		System.out.println();
		
		// registerCourseStudent(personCourse); (x) extends Student 하지 않음
		// registerCourseStudent(workerCourse); (x)
		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudentCourse);
		System.out.println();
		
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
		//registerCourseWorker(studentCourse); 	worker와 super(부모클래스)인 perosn만 가능
		//registerCourseWorker(highStudentCourse);

	}

}
