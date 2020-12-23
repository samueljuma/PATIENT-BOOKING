import java.util.ArrayList;

public class Patient {
    private String first_name, surname, telephone, date_of_birth, country_of_origin;
    // list of patient appointments
    private ArrayList<Appointment> appointments = new ArrayList<>();

    public Patient(String first_name, String surname, String telephone,
                   String date_of_birth, String country_of_origin) {
        this.first_name = first_name;
        this.surname = surname;
        this.telephone = telephone;
        this.date_of_birth = date_of_birth;
        this.country_of_origin = country_of_origin;
    }

    //getters
    public String getCountry_of_origin() {
        return country_of_origin;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return first_name + " " + surname + " " + telephone + " " + date_of_birth + " " + country_of_origin;
    }
}
