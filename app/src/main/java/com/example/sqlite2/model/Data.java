package com.example.sqlite2.model;

public class Data {
    public String id,name,address;
    public Data(){

    }
    public  Data (String id, String name, String address){
        this.id =id;
        this.name=name;
        this.address=address;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
}

