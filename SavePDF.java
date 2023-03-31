/*
package projectbms;
import com.itextpdf.text.Document;
import com.itextpdf.text.Table;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.scene.control.TableView;

public class SavePDF {
    
public void saveToPDF(TableView table, String fileName) {
    
  Document document = new Document();
  try {
    PdfWriter.getInstance(document, new FileOutputStream(fileName));
    document.open();
    Table pdfTable = new Table(table.getColumns().size());
    for (int i = 0; i < table.getColumns().size(); i++) {
      pdfTable.addCell(table.getColumns().get(i).getText());
    }
    for (int i = 0; i < table.getItems().size(); i++) {
      for (int j = 0; j < table.getColumns().size(); j++) {
        pdfTable.addCell(table.getColumns().get(j).getCellData(i).toString());
      }
    }
    document.add(pdfTable);
    document.close();
  } catch (Exception e) {
    e.printStackTrace();
  }
}

}
*/