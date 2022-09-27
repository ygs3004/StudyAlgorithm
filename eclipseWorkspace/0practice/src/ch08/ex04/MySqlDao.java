package ch08.ex04;

public class MySqlDao implements DataAccessObject {

	@Override
	public String select() {
		String str = "MySql DB에서 검색";
		System.out.println(str);
		return str;
	}

	@Override
	public String insert() {
		String str = "MySql DB에 삽입";
		System.out.println(str);
		return str;
	}

	@Override
	public String update() {
		String str = "MySql DB를 수정";
		System.out.println(str);
		return str;
	}

	@Override
	public String delete() {
		String str = "MySql DB에서 삭제";
		System.out.println(str);
		return str;
	}
}
