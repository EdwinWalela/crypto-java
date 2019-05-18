import com.google.zxing.WriterException;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String user = sc.next();
        System.out.println("Enter Number of Tickets(Pax): ");
        int pax = sc.nextInt();
        // Ticket Payload
        Ticket newPayload = new Ticket(user,"Oscars",pax);
        // GEnerate QR
        try {
            QRGenerator.generateQRImage(newPayload, "./ticket.png");
        }catch (WriterException e){

        }catch (IOException e){

        }
        // Hash Secret
        String SECRET = "1{%)* @:A";
        // Calculate Hash
        String digest = HashGenerator.sha256(newPayload,SECRET);
        // Output Hash
        System.out.println("Ticket Hash Digest: "+digest);
        System.out.println("Ticket QRCode generated (ticket.png)");

    }
}
