package Templates;

import java.util.Arrays;
import java.util.Comparator;

public class EDF {

    // 一个抽象的进程
    public static class Process {
        public int startTime; // 开始时间
        public int endTime; // 结束时间

        public Process(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static class ProcessComparator implements Comparator<Process> {
        @Override
        public int compare(Process o1, Process o2) {
            return o1.endTime - o2.endTime;
        }
    }

    // 统计在截止时间内能够完成的最大任务数量，截止时间优先算法，贪心策略
    public static int edf(Process[] processes, int curTime) {

        Arrays.sort(processes, new ProcessComparator());

        int count = 0;
        for (int i = 0; i < processes.length; i++) {
            if (curTime <= processes[i].startTime) {
                count++;
                curTime = processes[i].endTime;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // 不要尝试去证明，面试的时候时间来不及
        // 历届 ACMer 金牌得主用贪心策略得奖，都不知道自己代码为什么对
        // 通常，他们都是考虑多个贪心策略，然后用对数器验证，通过即可

        // 从当前时间 0 开始算起，每个任务都有开始时间和结束时间
        // 统计能够在截止时间内完成的最大任务数量
        int count = edf(new Process[] {
                new Process(4, 5),
                new Process(2, 6),
                new Process(8, 19)
        }, 0);

        System.out.println(count);
    }

}
