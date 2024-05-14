package optional;

import java.util.Optional;

public class OptionalMain {

	public static void main(String[] args) {
		
//		Optional<String> uno = Optional.of("stringa");
//		System.out.println(uno.get());
		
		Optional<String> due = Optional.ofNullable(null) ;
		System.out.println(due.isEmpty());
//		due.get();
		
		
	}
}
