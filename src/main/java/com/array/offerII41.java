package array;

import java.util.ArrayDeque;
import java.util.Queue;

public class offerII41 {
    public static void main(String[] args) {
        MovingAverage obj = new MovingAverage(5);
        double param_1 = obj.next(5);
        double param_2 = obj.next(2);
        double param_3 = obj.next(10);

        System.out.println(param_1+"   "+param_2+"   "+param_3);

    }


}


class MovingAverage {
    Queue<Integer> queue;
    int size;
    double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new ArrayDeque<Integer>();
        this.size=size;
        sum = 0;
    }

    public double next(int val) {
        if(queue.size()==size){
            sum -= queue.poll();
        }
        queue.offer(val);
        sum +=val;
        return sum/queue.size();
    }
}
