

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Assert;
import org.junit.Test;

import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.log.SysoLogger;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.security.PdfPKCS7;

public class PDFSignature {

	public PdfPKCS7 verifySignature(AcroFields fields, String name) throws GeneralSecurityException, IOException {
		System.out.println("Signature covers whole document: " + fields.signatureCoversWholeDocument(name));
		System.out.println("Document revision: " + fields.getRevision(name) + " of " + fields.getTotalRevisions());
        PdfPKCS7 pkcs7 = fields.verifySignature(name);
        System.out.println("Integrity check OK? " + pkcs7.verify());
        return pkcs7;
	}
	
	public void verifySignatures(String path) throws IOException, GeneralSecurityException {
		System.out.println(path);
        PdfReader reader = new PdfReader(path);
        AcroFields fields = reader.getAcroFields();
        ArrayList<String> names = fields.getSignatureNames();
        if(names.size()== 0) 
        	System.out.println("document not signed");
         
        else {
		for (String name : names) {
			System.out.println("===== " + name + " =====");
			System.out.println("Signature covers whole document: " + fields.signatureCoversWholeDocument(name));
			System.out.println("Document revision: " + fields.getRevision(name) + " of " + fields.getTotalRevisions());
	        PdfPKCS7 pkcs7 = fields.verifySignature(name);
	        System.out.println("Integrity check OK? " + pkcs7.verify());
		}
		
        }
	}
	
	
	
	public static void main(String[] args) throws Exception {
		  JFileChooser fileChooser = new JFileChooser();
	      int returnValue = fileChooser.showOpenDialog(null);
	      String path1 = null;
	      if (returnValue == JFileChooser.APPROVE_OPTION) {
	        File selectedFile = fileChooser.getSelectedFile();
	         path1 = fileChooser.getSelectedFile().getAbsolutePath();
		
	      }
		LoggerFactory.getInstance().setLogger(new SysoLogger());
		BouncyCastleProvider provider = new BouncyCastleProvider();
		Security.addProvider(provider);
		PDFSignature app = new PDFSignature();
		app.verifySignatures(path1);
	}
}


