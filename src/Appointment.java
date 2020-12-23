public class Appointment {
    private Patient patient;
    private String time_of_appointment;
    private String name_of_doctor;

    //constructor
    public Appointment(Patient patient, String time_of_appointment, String doctor) {
        this.patient = patient;
        this.time_of_appointment = time_of_appointment;
        this.name_of_doctor = doctor;
    }

    public String getName_of_doctor() {
        return name_of_doctor;
    }

    public String getTime_of_appointment() {
        return time_of_appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return patient.getFirst_name() + " " + patient.getSurname()
                + "\t" + time_of_appointment + "\t\t" + name_of_doctor;
    }
}
