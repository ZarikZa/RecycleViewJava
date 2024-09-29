package com.example.paraxz;

public class State {
    private String name;
    private String capital;
    private int flag;

    public State(String name, String capital, int flag) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;
    }

    public String getName() {
        return this.name;
    }

    public String setName(String name) {
        return this.name;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getFlagResource(){
        return this.flag;
    }

    public void setFlag(int flagResource){
        this.flag = flag;
    }





}