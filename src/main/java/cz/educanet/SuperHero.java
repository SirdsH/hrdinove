package cz.educanet;

public class SuperHero {
    private String pseudonym;
    private String fullName;
    private String gender;
    private String rasa;
    private String tym;

    public SuperHero(String pseudonym, String fullName, String gender, String rasa, String tym) {
        this.pseudonym = pseudonym;
        this.fullName = fullName;
        this.gender = gender;
        this.rasa = rasa;
        this.tym = tym;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getTym() {
        return tym;
    }

    public void setTym(String tym) {
        this.tym = tym;
    }
}
