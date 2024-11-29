package org.example.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;


    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }
    public Set<Task> getTasks(String name){ //Bu metod, ilgili isme göre ilgili kişinin taskını verir.
        switch (name) {
            case "ann":
                return this.annsTasks;
            case "bob":
                return this.bobsTasks;
            case "carol":
                return this.carolsTasks;
            case "all":
                return getUnion(bobsTasks,annsTasks,carolsTasks);
            default:
        }
        return new HashSet<>();
    }

    public Set<Task> getUnion(Set<Task>...sets) { // js'deki spread operatoru gibi, bu kullanımda istersek 1 istersek 3 parametre gönderebiliriz. Tek şart veri tipinin task set olması gerekmektedir.
        HashSet<Task> allTask = new LinkedHashSet<>();
        for(Set<Task> tasks : sets){
            allTask.addAll(tasks);
        }
        return allTask;
    }
    public Set<Task> getIntersection(Set<Task> first, Set<Task> second){
        Set<Task> intersection = new HashSet<>(first);
        intersection.retainAll(second);
        return intersection;
    }
    public Set<Task> getDifferences(Set<Task> first, Set<Task> second){
        Set<Task> difference = new HashSet<>(first);
        difference.removeAll(second); //first içindeki elemanlar ile second içindeki elemanları kıyaslar. Firstte olan, secondda olmayanları difference'de tutar ve döner.
        return difference ;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTask() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }
}
