package school;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 刘廷利的代码
 * 201902099
 */
public class HuffmanEncode {
    /**
     * 存放结点
     */
    public static final LinkedList<HuffNode> huffList = new LinkedList<>();

    /**
     * 内部结点类
     */
    public static class HuffNode implements Comparable<HuffNode> {
        /**
         * 节点名
         */
        String name;
        /**
         * 权值
         */
        int value;
        /**
         * 左子树
         */
        HuffNode lChild = null;
        /**
         * 右子树
         */
        HuffNode rChild = null;

        /**
         * 新结点
         *
         * @param name  结点名
         * @param value 结点权值
         */
        public HuffNode(String name, int value) {
            this.name = name;
            this.value = value;
        }

        /**
         * 权值之和，即合并两个叶子节点
         * @param lChild 左子树
         * @param rChild 右子树
         */
        public HuffNode(HuffNode lChild, HuffNode rChild) {
            this.lChild = lChild;
            this.rChild = rChild;
            this.value = lChild.value + rChild.value;
        }

        /**
         * 按照权值大小非严格递减
         */
        @Override
        public int compareTo(HuffNode o) {
            return Integer.compare(this.value, o.value);
        }
    }

    /**
     * 编码编码
     */
    public static void huffmanCode() {
        // 如果只有根节点，直接退出
        if (huffList.size() == 1) {
            return;
        }
        // 编码完成后，huffList 中只剩一个根节点
        while (huffList.size() > 1) {
            // 排序
            Collections.sort(huffList);
            // 将前两个节点进行合并
            HuffNode node = new HuffNode(huffList.get(0), huffList.get(1));
            // 删除前两个节点
            huffList.remove();
            huffList.remove();
            // 将新生成的节点追加到列表中
            huffList.add(node);
        }
    }

    /**
     * 解码哈夫曼树
     * @param n 当前的结点，如果是叶子节点，直接输出，如果是非叶子节点，则继续往下遍历
     * @param code 当前编码
     */
    public static void decode(HuffNode n, String code) {
        // 叶子节点， 输出其对应编码
        if ((n.lChild == null) && (n.rChild == null)) {
            System.out.println(n.name + "->" + code);
            return;
        }
        // 非叶子结点，直接往下遍历
        decode(n.lChild, code + "0");
        decode(n.rChild, code + "1");
    }
    /**
     * 主函数
     */
//    public static void main(String[] args) {
//        System.out.println("Huffman nodes count: ");
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println("Details of nodes, format:(name value): ");
//        for (int i = 0; i < n; i++) {
//            huffList.add(new HuffmanEncode.HuffNode(sc.next(), sc.nextInt()));
//        }
//        huffmanCode();
//        System.out.println("Encoding of each Huffman node, format:(name->value): ");
//        decode(huffList.get(0), "");
//    }

}
