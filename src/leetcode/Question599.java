package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Question599 {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        // 边界判定
        if (list1.length < 1 || list2.length < 1 || list1.length > 1000 || list2.length > 1000) {
            return null;
        }
        // 存放第一个人最喜欢的餐馆 list，同时记录其下标
        HashMap<String, Integer> map = new HashMap<>();
        // 记录两人共同喜爱的参观
        HashMap<String, Integer> common = new HashMap<>();
        // 遍历 list1，加入 map
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        // 遍历 list2，如果发现有共同爱好的餐馆，则取出其值，计算索引和，然后加入 common
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                common.put(list2[i], map.get(list2[i]) + i);
            }
        }
        // 对 common 的 values 进行排序，默认从小到大
        List<Integer> list = common.values().stream().sorted().collect(Collectors.toList());
        // 具有相同索引和的餐馆名 list
        List<String> keyList = new ArrayList<>();
        // 遍历 common 的 value，如果其 value 相等，就将其 key（餐馆名）加入 keyList
        for (String key : common.keySet()) {
            if (common.get(key).equals(list.get(0))) {
                keyList.add(key);
            }
        }
        // 形成数组返回
        return keyList.toArray(new String[0]);
    }
}
