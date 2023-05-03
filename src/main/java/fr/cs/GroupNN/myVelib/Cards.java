package fr.cs.GroupNN.myVelib;

public class Cards {
    // Vlibre and Vmax are the two registration types
    private String registrationType;

    public Cards(String registrationType) {
        this.registrationType = registrationType;
    }


    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }
}
