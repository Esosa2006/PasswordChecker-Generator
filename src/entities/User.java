package entities;

import java.util.ArrayList;

public class User {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private ArrayList<String> list_of_hobbies;
    private ArrayList<String> schools;
    private ArrayList<String> sports_teams;

    public User() {

    }

    public User(Long id, String first_name, String last_name, String email, ArrayList<String> list_of_hobbies, ArrayList<String> schools, ArrayList<String> sports_teams) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.list_of_hobbies = list_of_hobbies;
        this.schools = schools;
        this.sports_teams = sports_teams;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {this.email = email;}

    public void setList_of_hobbies(ArrayList<String> list_of_hobbies) {this.list_of_hobbies = list_of_hobbies;}

    public void setSchools(ArrayList<String> schools) {
        this.schools = schools;
    }

    public void setSports_teams(ArrayList<String> sports_teams) {
        this.sports_teams = sports_teams;
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getEmail() {return email;}

    public String getLast_name() {
        return last_name;
    }

    public ArrayList<String> getList_of_hobbies() {
        return list_of_hobbies;
    }

    public ArrayList<String> getSchools() {
        return schools;
    }

    public ArrayList<String> getSports_teams() {
        return sports_teams;
    }

    public void addHobby(String hobby){
        list_of_hobbies.add(hobby);
    }
    public void addSchool(String school){
        schools.add(school);
    }
    public void addSportsTeam(String team){
        sports_teams.add(team);
    }
}
