import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256  {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System. in);
        String inputString = scanner. nextLine();

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        byte[] messageByte = messageDigest.digest(inputString.getBytes(StandardCharsets.UTF_8));
        String hashText = DatatypeConverter.printHexBinary(messageByte).toLowerCase();

        System.out.println(hashText);
    }

}
