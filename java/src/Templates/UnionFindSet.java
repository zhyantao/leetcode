package Templates;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFindSet<V> {

    // 节点类型
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    // 封装用户类型 V -> Element<V>
    public HashMap<V, Element<V>> elementMap;
    // 保存 element 到父节点的映射
    public HashMap<Element<V>, Element<V>> fatherMap;
    // 在顶级父节点上保存该 map 包含元素的个数
    public HashMap<Element<V>, Integer> sizeMap;

    // 初始化并查集，每个元素自成一个集合
    public UnionFindSet(List<V> list) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();

        for (V value : list) {
            Element<V> element = new Element<V>(value);
            elementMap.put(value, element);
            fatherMap.put(element, element);
            sizeMap.put(element, 1);
        }
    }

    // 找到 element 的顶级父元素
    private Element<V> findHead(Element<V> element) {
        Stack<Element<V>> path = new Stack<>();

        while (element != fatherMap.get(element)) {
            path.push(element);
            element = fatherMap.get(element);
        }

        // 扁平化 HashMap（优化）
        while (!path.isEmpty()) {
            fatherMap.put(path.pop(), element);
        }

        return element;
    }

    // 判断两个元素是否属于同一个集合
    public boolean isSameSet(V a, V b) {
        // 确保集合中含有 a 和 b
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }

        return false;
    }

    // 合并两个集合
    public void union(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<V> aFather = findHead(elementMap.get(a));
            Element<V> bFather = findHead(elementMap.get(b));

            // 若 a 和 b 所属的集合不同，则合并
            if (aFather != bFather) {
                Element<V> big = sizeMap.get(aFather) >= sizeMap.get(bFather) ? aFather : bFather;
                Element<V> small = big == aFather ? bFather : aFather;
                fatherMap.put(small, big);
                sizeMap.put(big, sizeMap.get(aFather) + sizeMap.get(bFather));
                sizeMap.remove(small); // sizeMap 只保留顶级节点
            }
        }
    }

}
