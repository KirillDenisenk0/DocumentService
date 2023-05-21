package DriverLicense;

import java.util.Objects;

public class DriverLicense extends Document {
    private int uniqueNumberOfLicense;

    public DriverLicense(String nameOfDocument, String nameOfOwner, String lastnameOfOwner, int uniqueNumberOfLicense) {
        super(nameOfDocument, nameOfOwner, lastnameOfOwner);
        this.uniqueNumberOfLicense = uniqueNumberOfLicense;
    }

    public DriverLicense(String nameOfDocument, int uniqueNumberOfLicense) {
        super(nameOfDocument);
        this.uniqueNumberOfLicense = uniqueNumberOfLicense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverLicense that = (DriverLicense) o;
        return uniqueNumberOfLicense == that.uniqueNumberOfLicense;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uniqueNumberOfLicense);
    }

    public int getUniqueNumberOfLicense() {
        return uniqueNumberOfLicense;
    }

    @Override
    public String toString() {
        return getNameOfDocument() + " " + getNameOfOwner() + " " + getLastnameOfOwner() + ": " + uniqueNumberOfLicense;
    }
}
