package Templates;

public class BloomFilter {

    public static void main(String[] args) {

        // 初始化 320 bits 的布隆过滤器
        int[] arr = new int[100];

        // 取出第 178 位
        int numIndex = 178 / 32; // 先找到这个数字对应的起始地址
        int bitIndex = 178 % 32; // 在找到这个数字相对于起始地址的偏移
        int s = (arr[numIndex] >> bitIndex) & 1; // 取出数字
        System.out.println(s);

        // 将第 178 位改为 1
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);

        // 将第 178 位改为 0
        arr[numIndex] = arr[numIndex] & (~(1 << bitIndex));

    }

}
