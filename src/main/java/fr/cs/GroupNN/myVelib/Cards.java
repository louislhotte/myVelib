package fr.cs.GroupNN.myVelib;

public class Cards {
    // VLIBRE and VMAX are the two registration types
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
