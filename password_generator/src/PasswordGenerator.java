/*
* Generates a random password that meets the following criteria:
* At least 1 uppercase letter (A-Z)
* At least 1 lowercase letter (a-z)
* At least 1 digit (0-9)
* At least 1 special character (e.g., !@#$%^&*()-_=+[]{}|;:'",.<>?/`~)
* The password must be at least 8 characters long and can be up to 20 characters long
*/

// Runs in O(N) time complexity, where N is the length of the password
// Storage complexity of O(N), where N is the length of the password
public class PasswordGenerator {
    public static void main(String[] args) throws Exception {
        int length = (int) (Math.random() * 13) + 8; // Random length between 8 and 20
        int[] password = new int[length]; // Array to store the initial password characters 

        randomPassword(password, length);
        additionalReqs(password, length); 

        // Outputs the generated password
        System.out.println("Generated Password: " + toString(password));
    }

    // Generates a random password of length 'length'
    public static void randomPassword(int[] password, int length) {
        for (int i = 0; i < length; i++) {
            // Generate a random usable character from the ASCII range and put it in the password array
            int ascii = (int) (Math.random() * (127 - 33)) + 33; 
            char c = (char) ascii;
            password[i] = c;
        }
    }

    // Fulfills additional requirements of the password
    public static void additionalReqs(int[] password, int length) {
        // Finds 4 unique indices in the password array to place the required characters
        // Calls randInt() to generate random indices within password array length
        int ind1 = randInt(length);
        int ind2 = randInt(length);
        int ind3 = randInt(length);
        int ind4 = randInt(length);

        // Ensure the indices are unique
        while (ind2 == ind1) {
            ind2 = randInt(length);
        }
        while (ind3 == ind1 || ind3 == ind2) {
            ind3 = randInt(length);
        }
        while (ind4 == ind1 || ind4 == ind2 || ind4 == ind3) {
            ind4 = randInt(length);
        }
        
        // Generate a random uppercase letter
        char upper = (char) ((int) (Math.random() * 26) + 65); 
        // Generate a random lowercase letter
        char lower = (char) ((int) (Math.random() * 26) + 97); 
        // Generate a random digit
        char digit = (char) ((int) (Math.random() * 10) + 48); 
        // Generate a random special character
        char special = (char) ((int) (Math.random() * 15) + 33); 

        // Assign the generated characters to the password array at the specified indices
        password[ind1] = upper;
        password[ind2] = lower;
        password[ind3] = digit;
        password[ind4] = special;
    }
   
    // Converts the password array to a string
    public static String toString(int[] password) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < password.length; i++) {
            sb.append((char) password[i]);
        }
        return sb.toString();
    }

    // Helper method
    // Generates a random number from one of the indices of the password array
    public static int randInt(int length) {
        return (int) (Math.random() * length);
    }
}
