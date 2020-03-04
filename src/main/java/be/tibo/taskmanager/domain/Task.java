package be.tibo.taskmanager.domain;

public class Task {
    private String naam;
    private String datum;

    public Task(String naam, String datum) {
        setNaam(naam);
        setDatum(datum);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}
