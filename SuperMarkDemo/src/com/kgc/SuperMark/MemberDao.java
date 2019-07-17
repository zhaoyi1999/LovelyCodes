package com.kgc.SuperMark;

import java.text.SimpleDateFormat;
import java.util.*;

/***
 * 业务类
 */
public class MemberDao {
	Scanner input = new Scanner(System.in);
	List<Member> memberList = new ArrayList<Member>();
	Member member;

	// 开始菜单
	public void menu() {
		System.out
				.println("**************************欢迎进入超市会员管理系统**************************");
		System.out.println("1.积分累计		2.积分兑换		3.查询会员		4.修改密码		5.开卡		6.退出");
		System.out
				.println("*********************************************************************");
		System.out.print("请选择：");
	}

	public void start() {
		do {
			menu();
			int choose = input.nextInt();
			switch (choose) {
			case 1:
				// 积分累计
				if (getScore()) {
					System.out.println("积分累积成功！");
				} else {
					System.out.println("积分累积失败！");
				}
				continue;
			case 2:
				// 积分兑换
				if (setScore()) {
					System.out.println("积分兑换成功！");
				} else {
					System.out.println("积分兑换失败！");
				}
				continue;
			case 3:
				// 查询剩余积分
				selectScore();
				continue;
			case 4:
				// 修改密码
				if (changePass()) {
				}
				continue;
			case 5:
				// 开卡
				regist();
				continue;
			case 6:
				// 退出
				exit();
				break;
			default:
				System.out.println("输入格式不正确，请重新输入！");
				continue;
			}
		} while (true);
	}

	/***
	 * 查询是否存在用户
	 * 
	 * @param cardId
	 * @param pass
	 * @return member
	 */
	public Member hasMember(int cardId, String pass) {
		for (Member member : memberList) {
			if (member.getCarId() == cardId && member.getPass().equals(pass)) {
				return member;
			}
		}
		return null;
	}

	/***
	 * 积分累计
	 */
	private boolean getScore() {
		System.out.print("请输入会员卡号：");
		int cardId = input.nextInt();
		System.out.print("请输入会员密码：");
		String pass = input.next();
		member = hasMember(cardId, pass);
		if (member != null) {
			System.out.print("请输入此次消费金额（1元=1积分）：");
			int score = input.nextInt();
			member.setScore(member.getScore() + score);
			System.out.println("累计成功，已累计" + member.getScore() + "分");
			return true;
		} else {
			System.out.println("会员不存在或密码有误！");
			return false;
		}
	}

	/***
	 * 积分兑换
	 */
	private boolean setScore() {
		System.out.print("请输入会员卡号：");
		int cardId = input.nextInt();
		System.out.print("请输入会员密码：");
		String pass = input.next();
		member = hasMember(cardId, pass);
		if (member != null) {
			System.out.println("欢迎您，" + member.getName() + "!您当前积分为："
					+ member.getScore());
			System.out.print("请输入此次需要兑换的积分（10分=1元）：");
			int score = input.nextInt();
			if (score <= member.getScore()) {
				member.setScore(member.getScore() - score);
				float money = score / 10;
				System.out.println("兑换成功，已抵扣" + money + "元，剩余积分:"
						+ member.getScore() + "分");
				return true;
			} else {
				System.out.println("积分不足！");
				setScore();
			}
		} else {
			System.out.println("会员不存在或密码有误！");
			return false;
		}
		return false;

	}

	/***
	 * 查询会员
	 */
	private void selectScore() {
		System.out.println("会员卡号\t\t姓名\t\t剩余积分\t\t开卡日期");
		for (Member member : memberList) {
			if (member == null) {
				System.out.println("会员信息为空！");
				return;
			}
			System.out.println(member.getCarId() + "\t" + member.getName()
					+ "\t\t" + member.getScore() + "\t\t"
					+ member.getRegistDate());
		}

	}

	/***
	 * 修改密码
	 */
	private boolean changePass() {
		return false;
	}

	/***
	 * 随机生成会员卡号
	 */
	public int createId() {
		Random rand = new Random();
		int cardId = rand.nextInt(99999999);
		for (Member member : memberList) {
			if (member.getCarId() == cardId) {
				createId();
			}
		}
		return cardId;
	}

	/***
	 * 开卡
	 */
	private void regist() {
		member = new Member();
		System.out.print("请输入注册姓名：");
		member.setName(input.next());
		// 会员卡号随机生成
		int cardId = createId();
		member.setCarId(cardId);
		String pass;
		do {
			System.out.print("请输入注册密码：");
			pass = input.next();
		} while (!member.setPass(pass));
		member.setPass(pass);

		// 默认开卡赠送100积分
		member.setScore(100);
		// 开卡日期
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月dd日");
		String sdate = formater.format(date);
		member.setRegistDate(sdate);
		System.out.println("欢迎您，" + member.getName() + "!系统自动赠送您100积分。您的会员卡号是"
				+ member.getCarId());
		memberList.add(member);
		start();
	}

	/***
	 * 退出
	 */
	private void exit() {
		System.out.println("感谢您的使用!");
		return;
	}

}
