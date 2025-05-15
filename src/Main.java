import Tools.PasswordStrengthChecker;
import entities.User;
import entities.Users;

import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public void askUser(){

    }
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
                System.out.println("Enter your first name: ");
                user_.setFirst_name(scanner.nextLine());
                System.out.println("Enter your last name: ");
                user_.setLast_name(scanner.nextLine());
                System.out.println("Enter your email: ");
                user_.setEmail(scanner.nextLine());
                System.out.println("How many hobbies do you have: ");
                int no_of_hobbies = scanner.nextInt();
                for (int i = 0; i < no_of_hobbies; i++){
                    System.out.println("Enter hobby: ");
                    String hobby = scanner.nextLine();
                    user_.addHobby(hobby);
                }
                System.out.println("How many schools have you attended: ");
                int no_of_schools = scanner.nextInt();
                for (int i = 0; i < no_of_schools; i++){
                    System.out.println("Enter school: ");
                    String school = scanner.nextLine();
                    user_.addHobby(school);
                }
                System.out.println("How many sports teams do you have: ");
                int no_of_teams = scanner.nextInt();
                for (int i = 0; i < no_of_teams; i++){
                    System.out.println("Enter team: ");
                    String team = scanner.nextLine();
                    user_.addSportsTeam(team);
                }
                System.out.println("Registration successful");
            }
            else if (user_input == 2){
                System.out.println("Enter your email: ");
                String email = scanner.nextLine();
                if (users.isUserInList(email)){
                    User user = users.getUser(email);
                    System.out.println("What password would you like to check: ");
                    String password = scanner.nextLine();
                    PasswordStrengthChecker passwordStrengthChecker = new PasswordStrengthChecker(user, password);
                    passwordStrengthChecker.verify();
                    passwordStrengthChecker.getPasswordStrength();
                }
            }
            else if (user_input == 3){

            }

        }
    }
}