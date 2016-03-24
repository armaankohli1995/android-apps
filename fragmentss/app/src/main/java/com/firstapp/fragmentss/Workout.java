package com.firstapp.fragmentss;


public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("The Limb Loosener","5 Handstand push-ups\n10 1-legged squats\n-15 Pull-ups"),
            new Workout("Core Agony","100 Pull-ups\n100 Sit-ups\n 100 Squats"),
            new Workout("The Wimp Special","5 Pull-ups\n10 Push-ups\n 15Squats"),
            new Workout("Strenth and Length","500 meter run\n21 x 1.5 pood kettleball swing\n 21 x pull-ups")
    };

    private Workout(String name,String description){
        this.name = name;
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return description;
    }
}
