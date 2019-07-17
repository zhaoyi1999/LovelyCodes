import java.util.LinkedList;

/***
 * 新闻标题类
 */
public class LinkedListDemo {
	public static void main(String[] args) {
		// 集合存储多条新闻标题
		NewsTitle title1 = new NewsTitle(1, "北京终于晴天了1", "admin1");
		NewsTitle title2 = new NewsTitle(2, "北京终于晴天了2", "admin2");
		NewsTitle title3 = new NewsTitle(3, "北京终于晴天了3", "admin3");
		NewsTitle title4 = new NewsTitle(4, "北京终于晴天了4", "admin4");
		NewsTitle title5 = new NewsTitle(5, "北京终于晴天了5", "admin5");

		LinkedList<NewsTitle> list = new LinkedList<NewsTitle>();
		list.addFirst(title1);
		list.add(title2);
		list.add(title3);
		list.add(title4);
		list.addLast(title5);

		for (NewsTitle titles : list) {
			NewsTitle title = titles;
			NewsTitle author = titles;
			System.out.println(title.getTitle() + ";创建者：" + author.getAuthor());
		}
		NewsTitle firstTitle;
		firstTitle =  list.getFirst();
		System.out.println("头条新闻：" + firstTitle.getTitle() + ";创建者："
				+ firstTitle.getAuthor());
	}
}
