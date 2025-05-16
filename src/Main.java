import Tools.PasswordStrengthChecker;
import Tools.RandomPasswordGenerator;
import entities.User;
import entities.Users;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Users users = new Users();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do: ");
        System.out.println("1. Register");
        System.out.println("2. Check password strength");
        System.out.println("3. Generate password");
        System.out.println("4. Quit");
        int user_input = scanner.nextInt();
        while(true){
            if (user_input == 1){
                User user_ = new User();
                scanner.nextLine();
                System.out.println("Enter your first name: ");
                user_.setFirst_name(scanner.nextLine());
                System.out.println("Enter your last name: ");
                user_.setLast_name(scanner.nextLine());
                System.out.println("Enter your email: ");
                user_.setEmail(scanner.nextLine());
                System.out.println("How many hobbies do you have: ");
                while(!scanner.hasNextInt()){
                    scanner.nextLine();
                    System.out.println("Enter a valid number: ");
                }
                int no_of_hobbies = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < no_of_hobbies; i++){
                    System.out.println("Enter hobby: ");
                    String hobby = scanner.nextLine();
                    user_.addHobby(hobby);
                }
                System.out.println("How many schools have you attended: ");
                while(!scanner.hasNextInt()){
                    scanner.nextLine();
                    System.out.println("Enter a valid number: ");
                }
                int no_of_schools = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < no_of_schools; i++){
                    System.out.println("Enter school: ");
                    String school = scanner.nextLine();
                    user_.addHobby(school);
                }
                System.out.println("How many sports teams do you have: ");
                while(!scanner.hasNextInt()){
                    scanner.nextLine();
                    System.out.println("Enter a valid number: ");
                }
                int no_of_teams = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < no_of_teams; i++){
                    System.out.println("Enter team: ");
                    String team = scanner.nextLine();
                    user_.addSportsTeam(team);
                }
                System.out.println("Registration successful");
                users.addUser(user_);
            }
            else if (user_input == 2){
                scanner.nextLine();
                System.out.println("Enter your email: ");
                String email = scanner.nextLine();
                if (users.isUserInList(email)){
                    User user = users.getUser(email);
                    if (user != null) {
                        System.out.println("What password would you like to check: ");
                        String password = scanner.nextLine();
                        PasswordStrengthChecker passwordStrengthChecker = new PasswordStrengthChecker(user, password);
                        passwordStrengthChecker.verify();
                        System.out.println("Password Strength: " + passwordStrengthChecker.getPasswordStrength());
                    }
                    else{
                        System.out.println("User found in list but could not be loaded.");
                    }
                }
                else{
                    System.out.println("User not found. Please register your details first");
                }
            }
            else if (user_input == 3){
                System.out.println("What is the length of your password: ");
                int length = scanner.nextInt();
                RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
                randomPasswordGenerator.setPasswordLength(length);
                randomPasswordGenerator.generatePassword();
                String password = randomPasswordGenerator.getPassword();
                System.out.println("New password: " + password);
            }
            else if (user_input == 4){
                System.out.println("Thank you for using this system!");
                break;
            }
            else{
                System.out.println("Enter a valid output: ");
            }
            System.out.println("Is there anything else you'd like to do: ");
            System.out.println("1. Register");
            System.out.println("2. Check password strength");
            System.out.println("3. Generate password");
            System.out.println("4. Quit");
            user_input = scanner.nextInt();
        }
    }
}