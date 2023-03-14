//https://leetcode.com/problems/single-threaded-cpu/description/
package Heap_PQ;
import java.util.*;

class Solution {

    private class Task {
        int index,enqueueTime,processingTime;
        public Task(int index, int enqueueTime, int processingTime) {
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }

    public int[] getOrder(int[][] tasks) {
        //PQ acc to the start time 
        PriorityQueue<Task> taskQueue = new PriorityQueue<>((x,y)-> x.enqueueTime-y.enqueueTime);

        //PQ acc to the processing time and in case same processing time then the lower index one first 
        PriorityQueue<Task> availableQueue = new PriorityQueue<>((x,y)->x.processingTime!=y.processingTime ? x.processingTime-y.processingTime : x.index-y.index);

        int[] result = new int[tasks.length];

        for(int i=0;i<tasks.length;i++) taskQueue.add(new Task(i, tasks[i][0], tasks[i][1]));

        //initialising the currentTime to top of the start time Q(taskQ)
        int index=0, currentTime = taskQueue.peek().enqueueTime;

        while(!taskQueue.isEmpty() || !availableQueue.isEmpty()) {
            
            while(!taskQueue.isEmpty() && taskQueue.peek().enqueueTime <= currentTime)
                availableQueue.add(taskQueue.remove());

            //if a task is undergoing at this currentTime
            if(!availableQueue.isEmpty()) {
                Task running=availableQueue.poll();
                currentTime = currentTime + running.processingTime;
                result[index++] = running.index;
            } 
            //this happens when the the process has been completed but ,
            //no Task is there in the tasksQ with enqueue time same as the currentTime
            //so we skip the time till the next enqueueTime
            else currentTime = taskQueue.peek().enqueueTime;
        }
        return result;
    }
}
