import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/***
 * 测试Set的使用
 */
public class SetDemo {
	public static void main(String[] args) {

		// 集合存储多条新闻标题
		NewsTitle title1 = new NewsTitle(1, "北京终于晴天了1", "admin1");
		NewsTitle title2 = new NewsTitle(2, "北京终于晴天了2", "admin2");
		NewsTitle title3 = new NewsTitle(3, "北京终于晴天了3", "admin3");
		NewsTitle title4 = new NewsTitle(4, "北京终于晴天了4", "admin4");
		NewsTitle title5 = new NewsTitle(5, "北京终于晴天了5", "admin5");
		
		Set<NewsTitle> set = new HashSet<NewsTitle>();
		set.add(title1);
		set.add(title2);
		set.add(title3);
		set.add(title4);
		set.add(title5);
		//遍历Set集合 1.foreach 2.Iterator迭代器

		System.out.println("********************foreach*********************");
		//foreach
		for (Object object : set) {
			NewsTitle titles = (NewsTitle)object;
			System.out.println(titles.getId()+"-"+titles.getTitle());
		}
		
		System.out.println("*****************Iterator迭代器*******************");
		//Iterator迭代器
		Iterator<NewsTitle> iter = set.iterator();	//获得迭代器iter
		//通过迭代器迭代出集合				迭代器的初始指针位于迭代器外部
		while (iter.hasNext()) {	//hasNext() 是否有下一个元素
			NewsTitle titles=(NewsTitle)iter.next();	//next()迭代下一个元素
			System.out.println(titles.getId()+"-"+titles.getTitle());
		}
		
	}
}
