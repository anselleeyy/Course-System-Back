package demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestAll {
	
	@Test
	public void test7() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.toString());
	}

}
