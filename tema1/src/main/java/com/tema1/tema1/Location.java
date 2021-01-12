package com.tema1.tema1;

public class Location {

    private  int id;
    private int token;

    public Location(int id, int token){
        this.id = id;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public void nrOfTokensExit() {
        this.token = token - 1;
    }

    public void nrOfTokensEnter() {
        this.token = token + 1;
    }

    @Override
    public String toString(){
        return "Location {" + "id=" +id+ " ,token=" +token +"} ";
    }
}
