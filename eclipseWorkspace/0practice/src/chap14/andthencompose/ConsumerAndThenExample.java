package chap14.andthencompose;

import java.util.function.Consumer;

//andThen(), compose(), <- 인터페이스 Consumer,Function,Operator 디폴트 메소드
public class ConsumerAndThenExample {

	public static void main(String[] args) {
		Consumer<Member> consumerA = (m) -> {
			System.out.println("consumerA : "+m.getName());
		};
		
		Consumer<Member> consumerB = (m) -> {
			System.out.println("consumerB : "+m.getId());
		};
		
		Consumer<Member> consumerAB=consumerA.andThen(consumerB);
		consumerAB.accept(new Member("홍길동", "hong",null));

	}

}