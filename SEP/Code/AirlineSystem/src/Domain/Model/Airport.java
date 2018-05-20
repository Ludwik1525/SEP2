package Domain.Model;

public class Airport {
    private String code;
    private String name;
    private String city;
    private String postcode;
    private String country;
    private int numberOfGates;

    public Airport(String code, String name, String city, String postcode, String country, int numberOfGates) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.numberOfGates = numberOfGates;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNumberOfGates(int numberOfGates) {
        this.numberOfGates = numberOfGates;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfGates() {
        return numberOfGates;
    }

    public String getCity() {
        return city;
    }

    public String getCode() {
        return code;
    }

    public String getCountry() {
        return country;
    }

    public String getPostcode() {
        return postcode;
    }

    @Override
    public String toString() {
        return "Name: "+getName()+"; Code: "+getCode()+"; Country: "+getCountry()+"; City: "+getCity()+"; Postcode: "
                +getPostcode()+"; Number of gates: "+getNumberOfGates();
    }
}
