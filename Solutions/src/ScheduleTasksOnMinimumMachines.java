import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an input array tasks of start and end times, find the minimum number of machines required to complete the tasks.
 *
 * Constraints
 * 1 ≤ tasks.length() ≤ 10³
 * 0 ≤ tasks[i].start < tasks[i].end ≤ 10⁴
 */

public class ScheduleTasksOnMinimumMachines {
    public static int minimumMachines(int[][] tasks) {

        int machines = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

        for(int[] task: tasks) {
            int startTime = task[0];
            int endTime = task[1];

            while(!minHeap.isEmpty() && minHeap.peek()<= startTime) {
                minHeap.poll();
            }

            minHeap.offer(endTime);

            machines = Math.max(machines, minHeap.size());
        }

        return machines;
    }
}
