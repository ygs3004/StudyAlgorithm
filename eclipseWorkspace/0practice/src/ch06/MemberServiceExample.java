package ch06;
// id:hong, password:12345일 경우에만 true(로그인 되었습니다)
// logout() 메소드의 내용은 "로그아웃 되었습니다."
public class MemberServiceExample {

	public static void main(String[] args) {
		MemberService memberService=new MemberService();
		boolean  result=memberService.login("hong","12345");
		
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
			
		}else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}

	}

}