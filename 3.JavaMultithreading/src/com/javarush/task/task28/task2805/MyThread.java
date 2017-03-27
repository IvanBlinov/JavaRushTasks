package com.javarush.task.task28.task2805;

/**
 * Created by vanya on 19.03.2017.
 */
public class MyThread extends Thread {

    private static int priority = 1;

    public MyThread() {
        this.setPriority(priority);
        if (priority == MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        } else {
            priority++;
        }
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(priority);
        if (priority == MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        } else {
            priority++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (priority > group.getMaxPriority()) {
            this.setPriority(group.getMaxPriority());
        } else {
            this.setPriority(priority);
        }
        if (priority == MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        } else {
            priority++;
        }
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(priority);
        if (priority == MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        } else {
            priority++;
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (priority > group.getMaxPriority()) {
            this.setPriority(group.getMaxPriority());
        } else {
            this.setPriority(priority);
        }
        if (priority == MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        } else {
            priority++;
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(priority);
        if (priority == MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        } else {
            priority++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (priority > group.getMaxPriority()) {
            this.setPriority(group.getMaxPriority());
        } else {
            this.setPriority(priority);
        }
        if (priority == MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        } else {
            priority++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (priority > group.getMaxPriority()) {
            this.setPriority(group.getMaxPriority());
        } else {
            this.setPriority(priority);
        }
        if (priority == MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        } else {
            priority++;
        }
    }
}
