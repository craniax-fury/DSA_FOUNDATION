package com.insignia.stacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MergeMeetings {

    static class Interval {
        int startTime;
        int endTime;

        Interval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        int getStartTime() {
            return this.startTime;
        }

        int getEndTime() {
            return this.endTime;
        }
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());

            List<Interval> intervals = new ArrayList<>();
            Stack<Interval> intervalStack = new Stack<>();

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                int startTime = Integer.parseInt(line.split(" ")[0]);
                int endTime = Integer.parseInt(line.split(" ")[1]);

                intervals.add(new MergeMeetings.Interval(startTime, endTime));
            }

            intervals.sort((interval1, interval2) -> {
                return interval2.startTime >= interval1.startTime ? -1 : 1;
            });

            for (int index = 0; index < n; index++) {
                if (intervalStack.size() > 0 && isBetween(intervalStack.peek(), intervals.get(index))) {
                    Interval tempInterval = intervalStack.pop();
                    intervalStack.push(new Interval(tempInterval.startTime,
                            tempInterval.endTime > intervals.get(index).endTime ? tempInterval.endTime
                                    : intervals.get(index).endTime));

                } else {
                    intervalStack.push(intervals.get(index));
                }

            }

            Stack<Interval> outputStack = new Stack<>();

            while (intervalStack.size() > 0) {
                Interval tempInterval = intervalStack.pop();
                outputStack.push(tempInterval);
                
            }

            while (outputStack.size() > 0) {
                Interval tempInterval = outputStack.pop();
                System.out.println("" + tempInterval.startTime + " " + tempInterval.endTime);                
            }
            
        }
    }

    private static boolean isBetween(Interval interval1, Interval interval2) {
        return interval2.startTime <= interval1.endTime;
    }
}
