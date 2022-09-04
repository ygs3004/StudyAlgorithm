package chap11.ex04;
// Member 클래스를 작성, Object의 toString()메소드를 오버라이딩 해서 
// blue:이파란 <- MemberExample에서 실행, 출력
public class Member {
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//코드 작성
	@Override
	public String toString() {
		return id+":"+name;
	}
}
