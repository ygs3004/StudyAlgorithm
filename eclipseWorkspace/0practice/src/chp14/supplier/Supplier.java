package chp14.supplier;
// 매개값은 없고 리턴값은 있음
import java.util.function.IntSupplier;

public class Supplier {

	public static void main(String[] args) {
		IntSupplier intSupplier = () -> {
			int num = (int)(Math.random()*6)+1;
			return num;
		};

		int num=intSupplier.getAsInt();
		System.out.println("눈의 수 : "+num);
	}

}
