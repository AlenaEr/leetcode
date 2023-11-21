package org.example.leetcode;

import java.util.*;

public class CPUOrder {
    /**
     * You have defined input as an array of tasks labeled by index from 0 to n - 1. Each task is an array of two elements:
     * tasks[i] = [enqueueTime_i, processingTime_i]. The first value means the time when the task will be available to
     * process and the second value represents the time needed to finish this task.
     * Let's suppose we have a single-core CPU that is allowed to process at most one task at a time and follows the rules:
     * 1. If the CPU is idle and there is no available task to process, the CPU remains idle until any task will be enqueued
     * 2. If the CPU is idle and there are available tasks, the CPU starts processing a task with the shortest processing time.
     * If there are multiple tasks with the same processing time, the CPU chooses the one with the lowest label
     * 3. CPU cannot switch context and pause processing a task in favor of another task — the task has to
     * be processed fully before any other task will be taken to further processing
     * 4. There is no time needed for the CPU to rest after processing a task — if the CPU finishes processing a task,
     * it can instantaneously take another task for processing.
     * The goal is to return the order in which tasks will be processed by the CPU by providing an array of labels.
     * Example:
     * input = [[1,2],[2,4],[3,2],[4,1]]
     * output = [0,2,3,1]
     */
    public static void main(String[] args) {
        CPUOrder cpuOrder = new CPUOrder();
        int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        int[] order = cpuOrder.getOrder(tasks);
        System.out.println(Arrays.toString(order)); // Output: [0, 2, 3, 1]
    }

    public int[] getOrder(int[][] tasks) {
        // Custom class to represent a task with index, enqueue time, and processing time
        class Task {
            int index;
            int enqueueTime;
            int processingTime;

            public Task(int index, int enqueueTime, int processingTime) {
                this.index = index;
                this.enqueueTime = enqueueTime;
                this.processingTime = processingTime;
            }
        }

        // Custom comparator to compare tasks based on their enqueue time and index
        Comparator<Task> taskComparator = (a, b) -> {
            if (a.processingTime == b.processingTime) {
                if (a.enqueueTime == b.enqueueTime)
                    return Integer.compare(a.index, b.index);
                return Integer.compare(a.enqueueTime, b.enqueueTime);
            }
            return Integer.compare(a.processingTime, b.processingTime);
        };

        // Priority queue to store available tasks sorted by enqueue time and processing time
        PriorityQueue<Task> availableTasks = new PriorityQueue<>(taskComparator);

        int n = tasks.length;
        int[] order = new int[n];
        int index = 0;
        long currentTime = 0;

        // Create a list to store the order of task execution
        List<Integer> executionOrder = new ArrayList<>();

        // Process the tasks
        while (index < n || !availableTasks.isEmpty()) {
            // Add available tasks to the priority queue
            while (index < n && tasks[index][0] <= currentTime) {
                availableTasks.add(new Task(index, tasks[index][0], tasks[index][1]));
                index++;
            }

            // If the CPU is idle and there are available tasks, start processing the task
            if (!availableTasks.isEmpty()) {
                Task currentTask = availableTasks.poll();
                currentTime = Math.max(currentTime, currentTask.enqueueTime) + currentTask.processingTime;
                executionOrder.add(currentTask.index); // Store the task index in the order of execution
            }
            else if (index < n) {
                currentTime = tasks[index][0];
            }
        }

        // Convert the list of task indices to the output array
        for (int i = 0; i < n; i++) {
            order[i] = executionOrder.get(i);
        }
        return order;
    }
}

