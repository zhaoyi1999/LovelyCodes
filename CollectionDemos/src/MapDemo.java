import java.util.*;
import java.util.Map.Entry;

/***
 * 存储国家的英文简称（键-key），国家全称（值-value）;以键值对的形式存储
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String, String> countries = new HashMap<String, String>(); // 获取Map（接口）
		countries.put("CN", "中华人民共和国"); // put(key,value)往Map里存储 键(key)值(value)对
		countries.put("RU", "俄罗斯联邦");
		countries.put("US", "美利坚合众国");
		countries.put("FR", "法兰西共和国");
		countries.put("EN", "大不列颠及北爱尔兰联合王国");

		System.out.println(countries.size()); // 获取Map的元素个数

		// 通过某个键（key）获取对应的值（value）
		String cnStr = countries.get("CN");
		System.out.println(cnStr);
		boolean keyFlag = countries.containsKey("US"); // containsKey(key)判断Map中是否包含某个键
		boolean valueFlag = countries.containsValue("美利坚合众国"); // containsKey(value)判断Map中是否包含某个值
		System.out.println("是否包含CN,美利坚合众国" + keyFlag + valueFlag);

		// 分别显示Map中键集、值集和键值对集
		System.out.println(countries.keySet());
		System.out.println(countries.values());
		System.out.println(countries);

		// 清空
		// countries.clear();
		if (countries.isEmpty()) {
			System.out.println("Map键值对已清空！");
		}

		// 逐条打印键集
		Set<String> keys = countries.keySet();
		Iterator<String> keysIter = keys.iterator();
		while (keysIter.hasNext()) {
			System.out.println(keysIter.next());
		}

		// 逐条打印值集
		Collection<String> values = countries.values();
		Iterator<String> valusIter = values.iterator();
		while (valusIter.hasNext()) {
			System.out.println(valusIter.next());
		}

		// 逐条打印键值对集 键值对的类型为(Map.Entry)
		Set<Entry<String,String>> countriesSet = countries.entrySet();
		Iterator<Entry<String, String>> countriesIter = countriesSet.iterator();
		while (countriesIter.hasNext()) {
			System.out.println(countriesIter.next());
		}
		for (Entry<String,String> object : countriesSet) {
			System.out.println(object.getKey()+"-"+object.getValue());
//			Entry me = (Entry) object;
//			me.getKey();
//			me.getValue();
		}

	}
}
