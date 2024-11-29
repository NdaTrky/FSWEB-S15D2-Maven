package org.example;

import org.example.entity.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Task> annsTasks = new HashSet<>();
        Task taskAnn = new Task("workintech", "dummy desc", "ann", Status.IN_PROGRESS, Priority.HIGH);
        Task taskAnn1 = new Task("workintech", "dummy desc1", "ann", Status.IN_PROGRESS, Priority.HIGH);
        annsTasks.add(taskAnn);
        annsTasks.add(taskAnn1);

        Set<Task> bobsTasks = new HashSet<>();
        Task taskBob = new Task("workintech", "dummy", "bob", Status.IN_PROGRESS, Priority.HIGH);
        Task taskBob1 = new Task("workintech", "dummy1", "bob", Status.IN_PROGRESS, Priority.HIGH);
        bobsTasks.add(taskBob);
        bobsTasks.add(taskBob1);

        Set<Task> carolTasks = new HashSet<>();
        Task taskCarol = new Task("workintech", "dummy", "carol", Status.IN_PROGRESS, Priority.HIGH);
        Task taskCarol1 = new Task("workintech", "dummy1", "carol", Status.IN_PROGRESS, Priority.HIGH);
        carolTasks.add(taskCarol);
        carolTasks.add(taskCarol1);


        Set<Task> unassignedTasks = new HashSet<>();
        Task unassignedTask = new Task("workintech", "dummy", null, Status.IN_PROGRESS, Priority.HIGH);
        unassignedTasks.add(unassignedTask);

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolTasks, unassignedTasks);
        System.out.println("bobtasks: "+taskData.getTasks("bob"));
        System.out.println("annytaks:"+taskData.getTasks("ann"));
        System.out.println("alltasks: "+taskData.getTasks("all"));
        taskData.getIntersection(annsTasks,bobsTasks);
        taskData.getIntersection(annsTasks, carolTasks);
        taskData.getIntersection(bobsTasks, carolTasks);

        System.out.println("unassigned:" + taskData.getDifferences(unassignedTasks,taskData.getTasks("ann")));

        System.out.println(("*************************************************"));

        StringSet.findUniqueWords();
    }

}