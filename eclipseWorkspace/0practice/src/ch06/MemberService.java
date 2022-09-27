package ch06;

public class MemberService {

	String id;
	String password;
	
	public boolean login(String id, String password){
		
		this.id=id;
		this.password=password;
		
		if(id.equals("hong") && password.equals("12345")) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public void logout(String id){
		
		this.id=id;
		if(id.equals("hong")) {
			System.out.println("로그아웃 되었습니다.");			
		}
	}
}
