import java.io.IOException;
import java.util.List;

import pdfone.PDFOne;
import pdfone.PdfDocument;
import pdfone.PdfException;
import pdfone.PdfFormField;
import pdfone.PdfFormSignatureField;
import pdfone.PdfSignature;

public class Create_signed_pdf {

  public static void main(String[] args) throws IOException, PdfException {

    // Create a PDF signature
    PdfSignature pdfSignature =
        new PdfSignature("testmenow@mailinator.com.pfx",  // pathname of PFX 
                         "test",                      // password for PFX
                         "I approve this document",       // description
                         "nadjib, zaki",                // reason
                         "ajirnajib@gmail..com",              // contact info
                         1);                              // page number

    // Load a document with blank form fields
    PdfDocument doc = new PdfDocument();

    // Load a PDF document with a blank signature
    doc.load("blank_signature_doc.pdf");

    // Retrieve a list of all signature fields
    List fields = doc.getAllFormFieldsOnPage(0, PdfFormField.TYPE_SIGNATURE);

    PdfFormSignatureField signatureField;
    // Iterate the list and fill the signature fields
    for (int i = 0; i < fields.size(); i++) {
      signatureField = (PdfFormSignatureField) fields.get(i);
      if (signatureField.isUnsigned()) {
        signatureField.fill(pdfSignature);
        break;
      }
    }
  
    doc.drawLine(10, 18, 200, 18);

    // Save the document to file
    doc.save("filled_signature_doc.pdf");
 
    // Close IO resources
    doc.close();
  }
}