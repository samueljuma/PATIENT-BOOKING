import java.util.ArrayList;
import java.util.Scanner;

public class Booking {
    private static Scanner scan = new Scanner(System.in);
    // RPMC DOCTORS
    private static final String[] DOCTORS = {"Dr. Daniel Hagan","Dr. Bravo Gilbert",
            "Dr. Steven Seagal","Dr. Igor Dondon"};
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
    public static void handleUserChoice(){
        while(true){
            mainMenu();
            int option = scan.nextInt();
            System.out.println("_________________________________________________");
            switch (option){
                // Register patient
                case 1: {
                    System.out.println("register patient");
                    break;
                }
                // Cancel Appointment
                case 2: {
                    System.out.println("Cancel appointment");
                    break;
                }
                // View a doctor's schedule
                case 3: {
                    System.out.println();
                    break;
                }
                // View patients appointments
                case 4: {
                    System.out.println("");
                    break;
                }
                case 5: {
                    return;
                }
                default: {
                    System.out.println("INVALID CHOICE: TRY AGAIN");
                }
            }
        }
    }
    public static void main(String[] args) {
        handleUserChoice();

    }
}
