package a0home.a00_MOCOCO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

public class A01_DATE_10699 {

	public static void main(String[] args) {
	
		
		Consumer<String> time = System.out::println;
		time.accept(LocalDate.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
		
	}
}
/* Exception?
  	Consumer<String> time = System.out::println;
		time.accept(LocalDate.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ofPattern("YYYY-MM-DD")));
		
		System.out.println((LocalDate.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ofPattern("YYYY-MM-DD"))));
 
*/