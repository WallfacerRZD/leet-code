/**
 *
 * @author WallfacerRZD
 * @date 2018/7/1 0:09
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
public class MergeIntervals {
    class MySolution {
        public List<Interval> merge(List<Interval> intervals) {
            List<Interval> linkedList = new LinkedList<>(intervals);
            linkedList.sort(Comparator.comparingInt(x -> x.start));
            for (int i = 0; i < linkedList.size() - 1; i++) {
                if (linkedList.get(i).end >= linkedList.get(i+1).start) {
                    int end1 = linkedList.get(i).end;
                    int end2 = linkedList.get(i+1).end;
                    Interval temp = new Interval(linkedList.get(i).start,
                            end1 > end2 ? end1 : end2);
                    linkedList.remove(i);
                    linkedList.remove(i);
                    linkedList.add(i, temp);
                    i--;
                }
            }
            return linkedList;
        }
    }

    /**
     * so intuitive
     */
    class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals.size() <= 1) {
                return intervals;
            }
            List<Interval> result = new LinkedList<>();
            intervals.sort(Comparator.comparingInt(x -> x.start));
            int start = intervals.get(0).start;
            int end = intervals.get(0).end;
            for (Interval interval : intervals) {
                if (interval.start <= end) {
                    end = Math.max(end, interval.end);
                } else {
                    result.add(new Interval(start, end));
                    start = interval.start;
                    end = interval.end;
                }
            }
            result.add(new Interval(start, end));
            return result;
        }
    }
}
