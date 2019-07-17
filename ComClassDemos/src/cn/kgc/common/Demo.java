package cn.kgc.common;

//包装类
public class Demo {
	public static void main(String[] args) {
		/*
		 * 包装类的构造方法：（1）如何把基本数据类型变成包装类 （2）如何把字符串变成包装类
		 */
		// 所有包装类都有的构造方法：将与之对应的基本数据做参数
		int i = 9;
		// Integer I = new Integer(i);
		// Double D = new Double(9.8);
		// Boolean B = new Boolean(true);
		// Character C = new Character('a');
		// System.out.println(I+""+D+B+C);

		// 除Character之外的包装类都有的构造方法：将字符串做参数
		// Boolean类构造方法番薯为String类型时，除true[不区分大小写]以外，都为false
		Integer I = new Integer('A');
		Double D = new Double("9.8");
		Boolean B = new Boolean("tRue");
		// Character C = new Character("a");

		// valueOf()
		// （1）如何把基本类型变成包装类
		I = Integer.valueOf(i);
		// （2）如何把字符串变成包装类（Character除外）
		I = Integer.valueOf("100");
		System.out.println(I + "" + D + B);
	}
}
