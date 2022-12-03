package gc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class LogGC {

	public static void main(String[] args) {

		Map map = new HashMap<Integer, Integer>();

		for (int i = 0; i < 1000000000; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, 10000000);
			map.put(i, randomNum );
		}

	}

}
