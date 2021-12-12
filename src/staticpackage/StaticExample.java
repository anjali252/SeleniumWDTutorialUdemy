package staticpackage;

public class StaticExample {
	String make;
	static int instanceNo;

	StaticExample(String make) {
		this.make = make;
		instanceNo++;
	}

	String getMake() {
		return make;
	}

	static int getInstanceNo() {
		return instanceNo;
	}
}
