public class Doctor {
    private String name;
    private int number_of_appointments;
    private String timeBooked;

    public Doctor(String name, int number, String time_booked) {
        this.name = name;
        this.number_of_appointments = number;
        this.timeBooked = time_booked;
    }

    public void setNumber_of_appointments(int number_of_appointments) {
        this.number_of_appointments = number_of_appointments;
    }

    public int getNumber_of_appointments() {
        return number_of_appointments;
    }

    public String getName() {
        return name;
    }

    public String getTimeBooked() {
        return timeBooked;
    }

    public void setTimeBooked(String timeBooked) {
        this.timeBooked = timeBooked;
    }
}
