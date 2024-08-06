package consumerExample;

import java.util.function.Consumer;

public class ConsumerDemo {
	
	public void usingLambda() {
		
		Consumer<String> con1 = input -> System.out.println(input+ " is a word");
		
		Consumer<String> con2 = input -> System.out.println(input+ " di mapla is an emotion");
		
		con1.andThen(con2).accept("Vanakam");
	}

	public static void main(String[] args) {
		ConsumerDemo c = new ConsumerDemo();
		c.usingLambda();
		
	}

}
