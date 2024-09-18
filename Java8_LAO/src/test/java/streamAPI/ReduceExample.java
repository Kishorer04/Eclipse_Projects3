package streamAPI;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7);
		
		Integer result= nums.stream()
		.reduce(0,(sum,elements)->sum+elements);
		
		System.out.println(result);
		
		//reduce is a terminal function
		//identity - initial value
		//accumulator - accumulator is a lambda expression/function that accumulates(joins) the values i.e. addition or multiplication
		
		
		//The above code is equivalent to:
		int sum = 0;
		for(Integer value: nums)
			sum+=value;
		
		System.out.println(sum);
		
		

	}

}
