package DriverLicense;

import java.util.Objects;

public class Document {
    private String nameOfDocument;
    private String nameOfOwner;
    private String lastnameOfOwner;

    public Document(String nameOfDocument) {
        this.nameOfDocument = nameOfDocument;
    }

    @Override
    public String toString() {
        return nameOfOwner + " " + lastnameOfOwner + ": " + nameOfDocument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Document document = (Document) o;
        return Objects.equals(nameOfDocument, document.nameOfDocument) && Objects.equals(nameOfOwner, document.nameOfOwner) && Objects.equals(lastnameOfOwner, document.lastnameOfOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfDocument, nameOfOwner, lastnameOfOwner);
    }

    public String getNameOfDocument() {
        return nameOfDocument;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getLastnameOfOwner() {
        return lastnameOfOwner;
    }

    public Document(String nameOfDocument, String nameOfOwner, String lastnameOfOwner) {
        this.nameOfDocument = nameOfDocument;
        this.nameOfOwner = nameOfOwner;
        this.lastnameOfOwner = lastnameOfOwner;
    }
}
