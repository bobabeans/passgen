import java.util.Arrays;
import java.util.Scanner;
import java.security.SecureRandom;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;

public class Passgen {
    public static void writePassword(String password, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(password);
        }
    }

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Clipboard clipboard = null;
        if (!GraphicsEnvironment.isHeadless()) {
            clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        }
        
        char[] numbers = "0123456789".toCharArray();
        char[] uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] special = "!@#$%^&*()-_=+[]{}|;:',.<>?/".toCharArray();

        System.out.print("Number amount? ");
        int numNumbers = scanner.nextInt();

        System.out.print("Lowercase letter amount? ");
        int numLower = scanner.nextInt();

        System.out.print("Uppercase letter amount? ");
        int numUpper = scanner.nextInt();

        System.out.print("Special character amount? ");
        int numSpecial = scanner.nextInt();

        appendRandomChars(sb, special, numSpecial, random);
        appendRandomChars(sb, numbers, numNumbers, random);
        appendRandomChars(sb, lowercase, numLower, random);
        appendRandomChars(sb, uppercase, numUpper, random);

        char[] passwordArray = sb.toString().toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[j];
            passwordArray[j] = temp;
        }

        try {
            String password = new String(passwordArray);
            if (password.length() > 1000) {
                writePassword(password, "password.txt");
                System.out.println("Password saved to password.txt");
            } else {
                if (GraphicsEnvironment.isHeadless()) {
                    System.out.println(password);
                    System.out.println("Clipboard not supported in headless mode");
                } else {
                    StringSelection selection = new StringSelection(password);
                    clipboard.setContents(selection, null);
                    System.out.println(password);
                    System.out.println("Password copied to clipboard");
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing password to file: " + e.getMessage());
        }

        scanner.close();
    }

    private static void appendRandomChars(StringBuilder sb, char[] source, int count, SecureRandom rand) {
        for (int i = 0; i < count; i++) {
            sb.append(source[rand.nextInt(source.length)]);
        }
    }
}