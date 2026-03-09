
public class Test {

	public static void main(String[] a) {
		
		double num1;
		Double num2 = new Double(3);
		String num3 = "5";
		num1 = num2.doubleValue() +
				Double.valueOf(num3).doubleValue();
		System.out.println(num1);
	}
	}
