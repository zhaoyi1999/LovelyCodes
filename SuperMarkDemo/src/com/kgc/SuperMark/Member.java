package com.kgc.SuperMark;

/***
 * 用户类
 */
public class Member {
	/***
	 * 姓名_String
	 */
	private String name;
	/***
	 * 卡号_int
	 */
	private int carId;
	/***
	 * 密码_String；长度不能小于6
	 */
	private String pass;
	/***
	 * 积分_int；值不能小于0
	 */
	private int score;
	/***
	 * 注册日期_String
	 */
	private String registDate;

	/***
	 * 无参构造方法
	 */
	public Member() {
	}

	/***
	 * 带参构造方法 姓名_String; 卡号_int; 密码_String; 积分_int; 注册日期_String;
	 */
	public Member(String name, int carId, String pass, int score,
			String registDate) {
		this.name = name;
		this.carId = carId;
		this.pass = pass;
		this.score = score;
		this.registDate = registDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getPass() {
		return pass;
	}

	public boolean setPass(String pass) {
		if (pass.length() < 6) {
			System.out.println("会员密码长度不能小于6！");
			return false;
		}
		this.pass = pass;
		return true;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
}
