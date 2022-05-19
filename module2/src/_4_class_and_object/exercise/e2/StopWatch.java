package _4_class_and_object.exercise.e2;

import java.util.Date;

public class StopWatch {
    private long startTime, endTime;
    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }
    public long getStartTime() {
        return this.startTime;
    }
    public long getEndTime() {
        return  this.endTime;
    }
    public void start() {
        this.startTime = System.currentTimeMillis();
    }
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return (this.endTime - this.startTime);
    }

    public static void main(String[] args) throws InterruptedException {
        int j = 0;
        StopWatch obj = new StopWatch();
        obj.start();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500);
        }
        obj.stop();
        System.out.println(obj.getElapsedTime());
    }


}
