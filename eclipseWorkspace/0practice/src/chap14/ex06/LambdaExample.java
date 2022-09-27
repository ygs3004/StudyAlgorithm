package chap14.ex06;

import java.util.function.ToIntFunction;

public class LambdaExample {
	private static Student[] student = {
		new Student("홍길동",90,96),
		new Student("신용권",95,93)
	};
	
	public static double avg(ToIntFunction<Student> function) {
		double avg=0;
		int sum=0;
		for(Student students:student) {
			sum+=function.applyAsInt(students);
		}
		avg=(double)sum/student.length;
		return avg;
	}
	
	
	public static void main(String[] args) {
		double englishAvg = avg(Student::getEnglishScore);
		System.out.println("영어 평균 점수:"+englishAvg);
		
		double mathAvg = avg(Student::getMathScore);
		System.out.println("수학 평균 점수:"+mathAvg);
	}
	
	public static class Student{
		private String name;
		private int englishScore;
		private int mathScore;
		
		public Student(String name, int englishScore, int mathScore) {
			this.name=name;
			this.englishScore=englishScore;
			this.mathScore=mathScore;
		}
		
		public String getName() {return name;}
		public int getEnglishScore(){return englishScore;}
		public int getMathScore(){return mathScore;}
	}
}