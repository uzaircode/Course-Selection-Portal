// AddressInfo is part of Composition.
// Definition : Composition Like Aggregation but the owned object is not
// independent from the owner which means by deleting owner the owned object
// will also be deleted.

public class AddressInfo {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public AddressInfo(String street, String city, String state, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return "HomeAddress [street=" + street + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode
                + ", country=" + country + "]";
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void validate() {
    }

}
