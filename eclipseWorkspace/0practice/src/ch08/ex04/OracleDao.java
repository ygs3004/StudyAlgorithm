package ch08.ex04;

public class OracleDao implements DataAccessObject {

	@Override
	public String select() {
		String str = "Oracle DB에서 검색";
		System.out.println(str);
		return str;
	}

	@Override
	public String insert() {
		String str = "Oracle DB에 삽입";
		System.out.println(str);
		return str;
	}

	@Override
	public String update() {
		String str = "Oracle DB를 수정";
		System.out.println(str);
		return str;
	}

	@Override
	public String delete() {
		String str = "Oracle DB에서 삭제";
		System.out.println(str);
		return str;
	}
}
