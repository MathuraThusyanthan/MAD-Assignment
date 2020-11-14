package com.mad.myapplication;

public class Joke {
    int ID;
    String Type;
    String Setuo;
    String PunchLine;

    public Joke(int ID, String type, String setuo, String punchLine) {
        this.ID = ID;
        Type = type;
        Setuo = setuo;
        PunchLine = punchLine;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSetuo() {
        return Setuo;
    }

    public void setSetuo(String setuo) {
        Setuo = setuo;
    }

    public String getPunchLine() {
        return PunchLine;
    }

    public void setPunchLine(String punchLine) {
        PunchLine = punchLine;
    }
}
