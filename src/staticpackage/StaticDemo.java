package staticpackage;

public class StaticDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticExample se1 = new StaticExample("bmw");
		System.out.println("Make of car = " + se1.getMake());
		System.out.println("Instance number of car =" + StaticExample.getInstanceNo());

		StaticExample se2 = new StaticExample("bmw");
		System.out.println("Make of car = " + se2.getMake());
		System.out.println("Instance number of car =" + StaticExample.getInstanceNo());
	}

}
