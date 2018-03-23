package pdfzippasword;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class pdfzippasword {

	public static void main(String[] args) throws IOException, DocumentException {
		// TODO Auto-generated method stub
		
		File outEncryptpdfFileName = new File("BANK_CHKMNGTDTLV4_18031500V56P4.PDF");
		FileInputStream filePdfCopy = new FileInputStream("BANK_CHKMNGTDTLV4_18031500V56P.PDF");   
		PdfReader pdfReader = new PdfReader(filePdfCopy);
	    PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(outEncryptpdfFileName));
	    String zipPassword1 = "testpass#";
	    String zipPassword = zipPassword1.trim();
	    zipPassword= URLEncoder.encode(zipPassword,"UTF-8");
		pdfStamper.setEncryption(zipPassword.getBytes("UTF-8"), zipPassword.getBytes("UTF-8"),
	        PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
	    
	    pdfStamper.close();
		pdfReader.close();
		filePdfCopy.close();

	}

}
