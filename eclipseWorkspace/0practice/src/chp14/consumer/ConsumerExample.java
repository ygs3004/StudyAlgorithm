package chp14.consumer;
// consumer -> 매개값은 있고 리턴값은 없음
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {

	public static void main(String[] args) {
		Consumer<String> consumer = t -> System.out.println(t+8);
		consumer.accept("Java");
		
		BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t+u);
		biConsumer.accept("Java","8");
		
		DoubleConsumer doubleConsumer = d->System.out.println("Java"+d);
		doubleConsumer.accept(8.0);
		
		ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t+i);
		objIntConsumer.accept("Java",8);
				
	}

}
