package chap13.wildcard;

public class Course<T> {
	private String name;
	private T[] students;

	public Course(String name, int capacity) {
		this.name=name;
		students=(T[])(new Object[capacity]); // 타입파라미터 배열 생성, new Tn(x)
	}										  // (T[])(new Object[n])으로 생성

	
	public String getName() {return name;}
	public T[] getStudents() {return students;}
	
	public void add(T t) {
		for(int i=0; i<students.length; i++) {
			if(students[i]==null) {
				students[i]=t;
				break;
			}
				
		}
	}
}

class Person{
	String string;
	Person(String string){this.string=string;}
	
	public String toString(){
		return string;
	}
}

class Worker extends Person{
	Worker(String string){
		super(string);
	}
}

class Student extends Person{
	Student(String string){
	super(string);	
	}
}

class HighStudent extends Student{
	HighStudent(String string){
		super(string);
	}
}