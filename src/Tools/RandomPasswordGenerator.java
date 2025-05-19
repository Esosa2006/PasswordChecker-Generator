package Tools;
import java.util.Random;

public class RandomPasswordGenerator {
    private String password;
    private int passwordLength;

    public void setPasswordLength(int length){
        passwordLength = length;
    }
    public void generatePassword(){
        StringBuilder password_builder = new StringBuilder();
        Random arrayNumber = new Random();
        Random arrayCharacter = new Random();
        String[] symbols = {"~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "-", "_", "+", "=", "{", "}", "[", "]", "|", ";", ":", "\"", ">", "<", ",", ".", "?", "/"};
        String[] lowercase = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String[] uppercase = new String[lowercase.length];
        int i = 0;
        System.out.println(lowercase[0]);
        for (String letter : lowercase){
            String upper = letter.toUpperCase();
            uppercase[i] = upper;
            i++;
        }
        for(int j = 0; j < passwordLength; j++){
            int array_to_be_chosen = arrayNumber.nextInt(4);
            if (array_to_be_chosen == 0){
                int character_from_symbols = arrayCharacter.nextInt(symbols.length);
                password_builder.append(symbols[character_from_symbols]);
            }
            else if (array_to_be_chosen == 1){
                int character_from_lowercase = arrayCharacter.nextInt(lowercase.length);
                password_builder.append(lowercase[character_from_lowercase]);
            }
            else if (array_to_be_chosen == 2) {
                int character_from_numbers = arrayCharacter.nextInt(numbers.length);
                password_builder.append(numbers[character_from_numbers]);
            }
            else{
                int character_from_uppercase = arrayCharacter.nextInt(uppercase.length);
                password_builder.append(uppercase[character_from_uppercase]);
            }
        }
        this.password = password_builder.toString();
    }

    public String getPassword() {return password;}
}
