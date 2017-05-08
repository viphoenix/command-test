package com.chengfeng;

import java.util.LinkedList;
import java.util.List;

/**
 * 内存
 * @author chengfeng on 2016/8/26.
 */
public class MemoryThread extends Thread {

    public MemoryThread() {
        super("MemoryThread");
    }

    private List<Person> personList = new LinkedList<Person>();

    @Override
    public void run() {
        while (true){
            for(int i = 0; i < 1000000; i++){
                personList.add(new Person(35L, "Jackson"));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            personList.clear();
        }

    }

    private class Person{

        Long age;
        String name;

        public Person(Long age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
