package fr.cs.Group07.myVelib;

public class Cards {
    // VLIBRE and VMAX are the two registration types
    private String registrationType;

    // Constructor
    public Cards(String registrationType) {
        super();
        this.registrationType = registrationType;
    }


    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }
}
