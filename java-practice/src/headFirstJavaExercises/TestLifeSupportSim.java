package headFirstJavaExercises;

import java.util.*;

class V2Radiator {
	V2Radiator(ArrayList<Object> list) {
		for (int x = 0; x < 5; x++) {
			list.add(new SimUnit(" V2Radiator"));
		}
	}
}

class V3Radiator extends V2Radiator {
	V3Radiator(ArrayList<Object> lglist) {
		super(lglist);
		for (int g = 0; g < 10; g++) {
			lglist.add(new SimUnit(" V3Radiator"));
		}
	}
}

class RetentionBot {
	RetentionBot(ArrayList<Object> rlist) {
		rlist.add(new SimUnit(" Retention"));
	}
}

public class TestLifeSupportSim {
	public static void main(String[] args) {
		ArrayList<Object> aList = new ArrayList<Object>();
		
//		V2Radiator v2 = new V2Radiator(aList);
		V3Radiator v3 = new V3Radiator(aList);
		for (int z = 0; z < 20; z++) {
			RetentionBot ret = new RetentionBot(aList);
		}
	}
}

class SimUnit {
	String botType;

	SimUnit(String type) {
		botType = type;
	}

	int powerUse() {
		if (" Retention".equals(botType)) {
			return 2;
		} else {
			return 4;
		}
	}
}