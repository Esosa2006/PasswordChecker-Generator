package Tools;

import entities.User;
import enums.Strength;

public class PasswordStrengthChecker {
    private final String password;
    private final User user;
    private boolean isMediumLength;
    private boolean isLong;
    private boolean isMixed;
    private boolean isCaseMixed ;
    private boolean isNumberMixed;
    private Strength passwordStrength;
    private boolean hasSymbols;
    private boolean hasEnoughSymbols;
    private boolean containsPersonalInfo;

    public PasswordStrengthChecker(User user, String password) {
        this.password = password;
        this.user = user;
    }

    public void checkLength(){
        if(password.length() <= 6){
            this.isLong = false;
            this.isMediumLength = false;
        }
        else if (password.length() <= 11){
            this.isLong = false;
            this.isMediumLength = true;
        }
        else {
            this.isLong = true;
        }
    }

    public boolean checkIfUppercase(String letter){
        String uppercaseVersion = letter.toUpperCase();
        return letter.equals(uppercaseVersion);
    }

    public boolean checkIfNumber(char character) {
        boolean isDigit = false;
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int number : numbers) {
            if (character == number) {
                isDigit = true;
                break;
            }
        }
        return isDigit;
    }

    public void checkIfMixed(){
        int caseMixedCount = 0;
        int numberMixedCount = 0;
        for (int i = 0; i < password.length() + 1; i++) {
            String firstCharacter = String.valueOf(password.charAt(i));
            String secondCharacter = String.valueOf(password.charAt(i + 1));
            if (!checkIfUppercase(firstCharacter) && checkIfUppercase(secondCharacter)) {
                this.isCaseMixed = true;
                caseMixedCount++;
            }
            if (checkIfUppercase(firstCharacter) && !checkIfUppercase(secondCharacter)) {
                this.isCaseMixed = true;
                caseMixedCount++;
            }
            if (!checkIfNumber(password.charAt(i)) && checkIfNumber(password.charAt(i + 1))) {
                this.isNumberMixed = true;
                numberMixedCount++;
            }
            if (checkIfNumber(password.charAt(i)) && checkIfNumber(password.charAt(i + 1))) {
                this.isNumberMixed = true;
                numberMixedCount++;
            }
        }
        if ((caseMixedCount >= password.length() / 2) && (numberMixedCount >= (password.length() / 2) - 1)) {
            this.isMixed = true;
        }
    }
    public void containsSymbols(){
        int symbolCount = 0;
        char[] password_to_characters = password.toCharArray();
        char[] symbols = {'~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '{', '}', '[', ']', '|', ';', ':', '"', '>', '<', ',', '.', '?', '/'};
        for (char passwordToCharacter : password_to_characters) {
            for (char character : symbols) {
                if (character == passwordToCharacter) {
                    symbolCount++;
                    this.hasSymbols = true;
                }
                else {
                    this.hasSymbols = false;
                }
            }
        }
        if(symbolCount > 1){
            this.hasEnoughSymbols = true;
        }
    }
    public void containsPersonalInfo(){
        if (password.contains(user.getFirst_name()) || password.contains(user.getLast_name())){
            this.containsPersonalInfo = true;
        }
        for (String hobby : user.getList_of_hobbies()){
            if (password.contains(hobby)) {
                this.containsPersonalInfo = true;
                break;
            }
        }
        for (String hobby : user.getSchools()){
            if (password.contains(hobby)) {
                this.containsPersonalInfo = true;
                break;
            }
        }
        for (String hobby : user.getSports_teams()){
            if (password.contains(hobby)) {
                this.containsPersonalInfo = true;
                break;
            }
        }
    }

    public void getPasswordStrength(){
        System.out.println(passwordStrength);
    }

    public void verify(){
        checkLength();
        checkIfMixed();
        containsPersonalInfo();
        containsSymbols();

        int score = 0;
        if (isMediumLength){ score += 1;}
        if (isLong){ score += 2;} // more weight for long
        if (isMixed) {score += 2;}
        if (isCaseMixed){ score += 1;}
        if (isNumberMixed){ score += 1;}
        if (hasSymbols){ score += 1;}
        if (hasEnoughSymbols) {score += 1;}

        if(score <= 2){
            this.passwordStrength = Strength.WEAK;
        }
        else if (score <= 5){
            this.passwordStrength = Strength.MEDIUM;
        }
        else{
            this.passwordStrength = Strength.STRONG;
        }
        if(containsPersonalInfo){this.passwordStrength = Strength.WEAK; }

    }
}
