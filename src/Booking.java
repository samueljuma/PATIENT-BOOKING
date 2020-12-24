import java.util.ArrayList;
import java.util.Scanner;

public class Booking {
    private static Scanner scan = new Scanner(System.in);
    // RPMC DOCTORS
    private static final String[] DOCTORS = {"Dr. Daniel Hagan", "Dr. Bravo Gilbert",
            "Dr. Steven Seagal", "Dr. Igor Dondon"};
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static final int NUMBEROFDOCTORS = 4;

    public static void mainMenu() {
        System.out.print("_________________________________________________"
                + "\n\n\tROTTEN PARK MEDICAL CENTRE (RMPC)"
                + "\n_________________________________________________"
                + "\n\t1.Book an Apointment"
                + "\n\t2.Cancel an Appointment"
                + "\n\t3.View a doctor's schedule"
                + "\n\t4.View a patient's Appointment"
                + "\n\t5.Exit"
                + "\n-------------------------------------------------"
                + "\n\tPlease enter an option: ");
    }

    public static void handleUserChoice() {
        // initialize doctors with number of apointments
        for (int i = 0; i < 4; i++) {
            Doctor doc1 = new Doctor(DOCTORS[i], 0, "");
            doctors.add(doc1);
        }
        while (true) {
            mainMenu();
            int option = scan.nextInt();
            System.out.println("_________________________________________________");
            switch (option) {
                // Register patient
                case 1: {
                    // patient info
                    System.out.println("\n****** ENTER PATIENT DETAILS******");
                    String first_name, surname, telephone, date_of_birth, country_of_origin;
                    // first name
                    System.out.print("First Name: ");
                    first_name = scan.next();
                    // surname
                    System.out.print("Surname: ");
                    surname = scan.next();
                    //telephone
                    System.out.print("Telephone: ");
                    telephone = scan.next();
                    //date of birth
                    System.out.print("Date of Birth: ");
                    date_of_birth = scan.next();
                    // country of origin
                    System.out.print("Country of Origin: ");
                    country_of_origin = scan.next();

                    Patient patient = new Patient(first_name, surname, telephone, date_of_birth, country_of_origin);

                    //Select time
                    System.out.print("\nEnter time (i.e 7:00AM): ");
                    String time_of_appointment = scan.next();
                    // display doctors available
                    System.out.println("\t***DOCTORS AVAILABLE***"
                            + "\n\tID\tName");
                    ArrayList<String> doctorsToChooseFrom = new ArrayList<>();
                    int count = 1;
                    for (int i = 0; i < NUMBEROFDOCTORS; i++) {
                        if ((doctors.get(i).getNumber_of_appointments() <= 7) && (!doctors.get(i).getTimeBooked().contains(time_of_appointment))) {
                            System.out.println("\t" + (count++) + "\t" + doctors.get(i).getName());
                            doctorsToChooseFrom.add(doctors.get(i).getName());
                        }
                    }
                    if (doctorsToChooseFrom.isEmpty()) {
                        System.out.println("\t FULLY BOOKED");
                        break;
                    }
                    // choose a doctor
                    System.out.print("Pick ID: ");
                    int pick = scan.nextInt() - 1;
                    Appointment appointment = new Appointment(patient, time_of_appointment, doctorsToChooseFrom.get(pick));
                    appointments.add(new Appointment(patient, time_of_appointment, doctorsToChooseFrom.get(pick)));

                    // update timebooked for the specific doctor
                    for (int i = 0; i < doctors.size(); i++) {
                        if (doctors.get(i).getName().equals(doctorsToChooseFrom.get(pick))) {
                            doctors.get(i).setTimeBooked(doctors.get(i).getTimeBooked() + time_of_appointment);
                        }
                    }
                    System.out.println("Booked successfully\n");
                    break;
                }
                // Cancel Appointment
                case 2: {
                    if (appointments.isEmpty()) {
                        System.out.println("\nNO APOINTMENTS YET");
                    } else {
                        System.out.println("******PRESENT APPOINTMENTS*****");
                        for (int i = 0; i < appointments.size(); i++) {
                            System.out.println((i + 1) + "." + appointments.get(i));
                        }
                        System.out.print("\nEnter Your Pick: ");
                        int pick = scan.nextInt();
                        // update time booked for doctor
                        for (int i = 0; i < doctors.size(); i++) {
                            if (doctors.get(i).getName().equals(appointments.get(pick-1).getName_of_doctor())) {
                                doctors.get(i).setTimeBooked(doctors.get(i).getTimeBooked().replaceAll(appointments.get(pick-1).getTime_of_appointment(), ""));
                            }

                        }
                        //remove appointment from list
                        appointments.remove(appointments.get(pick-1));

                        System.out.println("Appointment Cancelled Successfully"
                                + "\n***REMAINING APPOINTMENTS***");
                        for (int i = 0; i < appointments.size(); i++) {
                            System.out.println((i + 1) + "." + appointments.get(i));
                        }
                    }
                    break;
                }
                // View a doctor's schedule
                case 3: {
                    System.out.println("Select From");
                    for ( int i=0;i<DOCTORS.length; i++){
                        System.out.println((i+1)+"."+DOCTORS[i]);
                    }
                    System.out.print("\nEnter Your Pick: ");
                    int pick = scan.nextInt();
                    //look up for doctors appointments in the list of apointments
                    System.out.println("\nPatient\t\tTime of Appointment");
                    for(int i=0; i<appointments.size();i++){
                        if ((DOCTORS[pick-1]).equals(appointments.get(i).getName_of_doctor())){
                            System.out.println(appointments.get(i).getPatient().getFirst_name()+
                                    " "+appointments.get(i).getPatient().getSurname() +"\t\t"+appointments.get(i).getTime_of_appointment() );
                        }
                        else if(!(DOCTORS[pick-1]).equals(appointments.get(i).getName_of_doctor())) {
//                            System.out.println("NO APPOINTMENTS FOR "+ DOCTORS[pick-1].toUpperCase()+" YET");
                            break;
                        }
                    }
                    break;
                }
                // View patients appointments
                case 4: {
                    if(appointments.isEmpty()){
                        System.out.println("\nNO APPOINTMENTS YET");
                    }else{
                        System.out.println("CURRENT APPOINTMENTS"
                                + "\n\nPatient's Name\tTime of Appointemt\t Doctor");
                        for(int i=0;i<appointments.size();i++){
                            System.out.println(appointments.get(i));
                        }
                    }
                    break;
                }
                case 5: {
                    return;
                }
                default: {
                    System.out.println("INVALID CHOICE: TRY AGAIN");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        handleUserChoice();

    }
}
