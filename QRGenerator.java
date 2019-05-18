import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRGenerator {
    public static void generateQRImage(Ticket ticket,String targetPath) throws IOException, WriterException {
        String val = "User: "+ticket.userId+"\nEvent: "+ticket.eventId+"\nPax: "+ticket.pax;
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(val,BarcodeFormat.QR_CODE,350,350);
        Path path = FileSystems.getDefault().getPath(targetPath);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
    }
}
