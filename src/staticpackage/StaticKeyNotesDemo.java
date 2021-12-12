package staticpackage;

public class StaticKeyNotesDemo {
	int addNo = 10;
	static int addNoStatic;

	int sum(int no) {
		return no + addNo;
	}

	static int sumStatic(int no) {
		return no + addNoStatic;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticKeyNotesDemo sknd = new StaticKeyNotesDemo();
		System.out.println("add sum = " + sknd.sum(20));
		System.out.println("Static sum = " + sumStatic(20));
	}

}
