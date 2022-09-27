package Training;

public class arrReturnTest {

	public static void main(String[] args) {
		ArrayReturn arrayReturn=new ArrayReturn();
		int[] saveArr=arrayReturn.returnArr();
		
		System.out.println(saveArr[0]+" "+saveArr[1]
				+" "+saveArr[2]);

	}
}