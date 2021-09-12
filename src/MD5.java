import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System. in);
        String inputString = scanner. nextLine();

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        byte[] messageByte = messageDigest.digest(inputString.getBytes());

        BigInteger no = new BigInteger(1, messageByte);

        String hashtext = no.toString(16);

        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        System.out.println(hashtext);

    }
}