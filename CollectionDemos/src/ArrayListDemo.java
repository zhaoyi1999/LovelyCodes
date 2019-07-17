import java.util.ArrayList;
import java.util.Iterator;

/***
 * 新闻管理
 */
public class ArrayListDemo {
	public static void main(String[] args) {
		// 集合存储多条新闻标题
		NewsTitle title1 = new NewsTitle(1, "北京终于晴天了1", "admin1");
		NewsTitle title2 = new NewsTitle(2, "北京终于晴天了2", "admin2");
		NewsTitle title3 = new NewsTitle(3, "北京终于晴天了3", "admin3");
		NewsTitle title4 = new NewsTitle(4, "北京终于晴天了4", "admin4");
		NewsTitle title5 = new NewsTitle(5, "北京终于晴天了5", "admin5");

		ArrayList<NewsTitle> list = new ArrayList<NewsTitle>();
		list.add(title1);
		list.add(title2);
		list.add(title3);
		list.add(title4);
		list.add(title5);

		int count = list.size();

		System.out.println("新闻标题的总数是：" + count);

		// 遍历list,取出每条新闻标题的题目

		for (int i = 0; i < list.size(); i++) {
			NewsTitle title = list.get(i);
			System.out.println(title.getTitle());
		}

		System.out.println("***********************************");

		for (NewsTitle titles : list) {
			NewsTitle title = titles;
			NewsTitle author = titles;
			System.out.print(title.getTitle());
			System.out.print(";创建者：");
			System.out.println(author.getAuthor());
		}

		Iterator<NewsTitle> iter = list.iterator();
		while (iter.hasNext()) {
			NewsTitle titles = iter.next();
			System.out.println("头条新闻：" + titles.getTitle() + ";创建者："
					+ titles.getAuthor());
		}

	}
}
