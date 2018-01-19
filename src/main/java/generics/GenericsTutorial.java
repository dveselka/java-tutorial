package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsTutorial {

	public static void main(String[] args) {
		
		BoxInteger x = new BoxInteger(1);
		BoxString y = new BoxString("a"); 
		
		List<AbstractValue<?>> list = new ArrayList<>();
		list.add(x);
		list.add(y);
				
		printList(list);
 		
	}

	private static void printList(List<AbstractValue<?>> list) {
		for(AbstractValue<?> v : list) {
			System.out.println("v=" + v.getValue() + " type=" + v.getClass().getName());
		}
	}
	
}
