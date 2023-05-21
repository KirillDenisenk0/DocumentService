package DriverLicense;

import java.util.Objects;

public class Passport extends Document {
    private int series;
    private int number;

    public Passport(String nameOfDocument, String nameOfOwner, String lastnameOfOwner, int series, int number) {
        super(nameOfDocument, nameOfOwner, lastnameOfOwner);
        this.series = series;
        this.number = number;
    }

    public Passport(String nameOfDocument, int number) {
        super(nameOfDocument);
        this.number = number;
    }

    public int getSeries() {
        return series;
    }

    public int getNumber() {
        return number;
    }

    public Passport(String nameOfDocument, int series, int number) {
        super(nameOfDocument);
        this.series = series;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return series == passport.series || number == passport.number;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), series, number);
    }

    @Override
    public String toString() {
        return  getNameOfDocument() + " " + getNameOfOwner() + " " + getLastnameOfOwner() + ": " + series + " " + number;
    }
}
