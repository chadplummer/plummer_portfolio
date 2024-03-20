package csci2010.plummerprogram4;

import java.io.Serializable;

/**
 * 
 * @author chad.plummer
 */
public class Player implements Serializable {
    private String name;
    private int age;
    private int rank;
    private String country;
    
    public Player(){
        name = null;
        age = 0;
        rank = 0;
        country = null;
    }
    public Player(String iName, int iAge, int iRank, String iCountry){
        name = iName;
        age = iAge;
        rank = iRank;
        country = iCountry;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getRank(){
        return rank;
    }
    public String getCountry(){
        return country;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setAge(int newAge){
        age = newAge;
    }
    public void setRank(int newRank){
        rank = newRank;
    }
    public void setCountry(String newCountry){
        country = newCountry;
    }
    
    @Override
    public String toString(){
    return ("Name: " + name + "\n" + 
            "Age: " + age + "\n" + 
            "Rank: " + rank + "\n" + 
            "Country: " + country);
    }
}
