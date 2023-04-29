// this file is not for this version 

package projectbms;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.text.SimpleDateFormat;
import java.util.Date;

public class last {
    PDDocument invc;
    last() {
    //Create Document
    invc = new PDDocument();
    //Create Blank Page
    PDRectangle myPageSize = new PDRectangle(600,1200);
    PDPage newpage = new PDPage(myPageSize);
    //Add the blank page
    invc.addPage(newpage);
  }
        
        String Title =new String (Constants.Title);
        String subTitle = new String (Constants.subTitle);
        
        String name  = new String (Constants.name);
        String phnNum1 = new String (Constants.phnNum1);
        String PhnNum2 =new String (Constants.PhnNum2);
        String gstNum =new String (Constants.gstNum);
        String address =new String (Constants.address);
        
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
        Date date = new Date();  
        
        String cName = new String ("K Padmaja ");
        String cPhn  =new String ("9247830862");
        String setdate  =new String (formatter.format(date));
        String InNum = new String ("01");
    
    void creatPdf(){
         
        try {
            File fontcr = new File("V://projectBms/CalibriRegular.ttf");
            PDFont font1 = PDType0Font.load(invc,fontcr);
            
            File fontcB = new File("V://projectBms/CalibriBold.ttf");
            PDFont font = PDType0Font.load(invc,fontcB);
            
            PDPage mypage = invc.getPage(0);
            PDPageContentStream cs = new PDPageContentStream(invc, mypage);

            
     cs.beginText();
     cs.setFont( font , 20);
     cs.newLineAtOffset(170, 750);
     cs.showText(Title);
     cs.endText();
            
      cs.beginText();
      cs.setFont(font, 18);
      cs.newLineAtOffset(270, 720);
      cs.showText(subTitle);
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.setLeading(30f);
      cs.newLineAtOffset(60, 670);
      cs.showText("Name                   : ");
      cs.newLine();
      cs.showText("Phone Number1 : ");
      cs.newLine();
      cs.showText("Phone Number2 : ");
      cs.newLine();
      cs.showText("GST Number      : ");
      cs.newLine();
      cs.showText("Address               : ");
      cs.endText();
            
      cs.beginText();
      cs.setFont(font1, 14);
      cs.setLeading(30f);
      cs.newLineAtOffset(170, 670);
      cs.showText(name);
      cs.newLine();
      cs.showText(phnNum1);
      cs.newLine();
      cs.showText(PhnNum2);
      cs.newLine();
      cs.showText(gstNum);
      cs.newLine();
      cs.showText(address);
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.setLeading(30f);
      cs.newLineAtOffset(330, 670);
      cs.showText("Costumer Name : ");
      cs.newLine();
      cs.showText("Phone Number   : ");
      cs.newLine();
      cs.showText("Date                     : ");
      cs.newLine();
      cs.showText("Inovice Number : ");
      cs.endText();
            
      cs.beginText();
      cs.setFont(font1, 14);
      cs.setLeading(30f);
      
      cs.newLineAtOffset(440, 670);
      cs.showText(cName);
      cs.newLine();
      cs.showText(cPhn);
      cs.newLine();
      cs.showText(setdate);
      cs.newLine();
      cs.showText(InNum);
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.newLineAtOffset(30, 500);
      cs.showText("NAME");
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.newLineAtOffset(140, 500);
      cs.showText("Qnt");
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.newLineAtOffset(180, 500);
      cs.showText("MRP");
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.newLineAtOffset(220, 500);
      cs.showText("TOT");
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.newLineAtOffset(270, 500);
      cs.showText("NET");
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.newLineAtOffset(320, 500);
      cs.showText("DIS");
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.newLineAtOffset(360, 500);
      cs.showText("NET ");
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.newLineAtOffset(410, 500);
      cs.showText("TAX");
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.newLineAtOffset(440, 500);
      cs.showText("TAX");
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.newLineAtOffset(490, 500);
      cs.showText("PRC");
      cs.endText();
      
      cs.beginText();
      cs.setFont(font, 14);
      cs.newLineAtOffset(530, 500);
      cs.showText("TOTAL PRC");
      cs.endText();
      
     cs.beginText();
     cs.setFont(font, 10);
     cs.newLineAtOffset(175, 480);
     cs.showText("(Of One)");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 10);
     cs.newLineAtOffset(217, 480);
     cs.showText("(Mrp)");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 10);
     cs.newLineAtOffset(270, 480);
     cs.showText("(Amt)");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 10);
     cs.newLineAtOffset(350, 480);
     cs.showText("(After dis)");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 10);
     cs.newLineAtOffset(415, 480);
     cs.showText("(%)");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 10);
     cs.newLineAtOffset(440, 480);
     cs.showText("(Amt)");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 10);
     cs.newLineAtOffset(490, 480);
     cs.showText("(Of One)");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 10);
     cs.newLineAtOffset(550, 480);
     cs.showText("(Incl Tax)");
     cs.endText();
     
     creatpage(1);
     cs.close();
      
    //Save the PDF
    int num=1;
    File file = new File("V://projectBms/Sample1.pdf");
 //   invc.save(file);
    System.out.println("PDF GENRATED");
    if(file.exists()){
        String filestr = "V://projectBms/Sample"+setdate+".pdf";
        invc.save(filestr);
        System.out.println("PDF GENRATED");
    }
        }catch (IOException e) {
        e.printStackTrace();
        }
    }
    
    void creatpage(int m){
        try{
            File fontcr = new File("V://projectBms/CalibriRegular.ttf");
            PDFont font1 = PDType0Font.load(invc,fontcr);
            
            File fontcB = new File("V://projectBms/CalibriBold.ttf");
            PDFont font = PDType0Font.load(invc,fontcB);
            
     PDPage newpage = new PDPage();
     invc.addPage(newpage);
      PDPage mypage1 = invc.getPage(m);
      PDPage mypage = invc.getPage(m);
   // PDPageContentStream cs = new  PDPageContentStream(invc, mypage1);
   
    PDPageContentStream cs= new PDPageContentStream(invc, mypage1, PDPageContentStream.AppendMode.OVERWRITE, true);
   //PDPageContentStream cs = new PDPageContentStream(invc, mypage);
   Scanner sc = new Scanner(System.in);
    
     int n =600;
     
     while(true){
         
         System.out.print("Enter product name :");
         String productname =sc.nextLine();
         
         if( "0".equals(productname)){
             
             
         cs.beginText();
         cs.setFont(font1, 12);
         cs.newLineAtOffset(40,n-20);
         cs.showText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " );
         cs.endText();
         
         
        cs.beginText();
        cs.setFont(font, 12);
        cs.newLineAtOffset(40, n-35);
        cs.showText("Total :");
        cs.endText();
         
     cs.beginText();
     cs.setFont(font, 12);
     cs.newLineAtOffset(100, n-35);
     cs.showText("20");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 12);
     cs.newLineAtOffset(170, n-35);
     cs.showText("1000");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 12);
     cs.newLineAtOffset(220, n-35);
     cs.showText("900");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 12);
     cs.newLineAtOffset(270, n-35);
     cs.showText("100");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 12);
     cs.newLineAtOffset(310, n-35);
     cs.showText("800");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 12);
     cs.newLineAtOffset(400, n-35);
     cs.showText("200");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 12);
     cs.newLineAtOffset(480, n-35);
     cs.showText("900");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(40, n-70);
     cs.showText("TAX DETAILS");
     cs.endText();
     
         cs.beginText();
         cs.setFont(font1, 12);
         cs.newLineAtOffset(40,n-85);
         cs.showText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " );
         cs.endText();
         
     cs.beginText();
     cs.setFont(font, 13);
     cs.newLineAtOffset(40, n-100);
     cs.showText("SALE VALUE");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 13);
     cs.newLineAtOffset(120, n-100);
     cs.showText("SGST%");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 13);
     cs.newLineAtOffset(170, n-100);
     cs.showText("TAX");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 13);
     cs.newLineAtOffset(230, n-100);
     cs.showText("SALE VALUE");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 13);
     cs.newLineAtOffset(300, n-100);
     cs.showText("CGST%");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 13);
     cs.newLineAtOffset(350, n-100);
     cs.showText("TAX");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(40, n-120);
     cs.showText("5000.00");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(120, n-120);
     cs.showText("9.00%");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(170, n-120);
     cs.showText("50.00");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(230, n-120);
     cs.showText("5000.00");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(300, n-120);
     cs.showText("9.00%");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(350, n-120);
     cs.showText("50.00");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(40,n-195);
     cs.showText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " );
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 13);
     cs.newLineAtOffset(40, n-215);
     cs.showText("Total");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 13);
     cs.newLineAtOffset(120, n-215);
     cs.showText("SGST");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 13);
     cs.newLineAtOffset(170, n-215);
     cs.showText("450.00");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 13);
     cs.newLineAtOffset(300, n-215);
     cs.showText("CGST");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 13);
     cs.newLineAtOffset(350, n-215);
     cs.showText("450.00");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(350, n-240);
     cs.showText("Total Net Amount   :");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(350, n-265);
     cs.showText("Total Tax ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 10);
     cs.newLineAtOffset(410, n-265);
     cs.showText("(CGST+SGST)");
     cs.endText();
    
      cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(465, n-265);
     cs.showText(": ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(350, n-290);
     cs.showText("Total Discount         :");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(350, n-315);
     cs.showText("Total Amount          : ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(470, n-240);
     cs.showText("69000.00 ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(470, n-265);
     cs.showText("9000.00 ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(470, n-290);
     cs.showText("8000.00 ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(470, n-315);
     cs.showText("70000.33 ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(350, n-340);
     cs.showText("Rounded to              : ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(470, n-340);
     cs.showText("70000.00 ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(40, n-360);
     cs.showText("Amount In Words : ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 14);
     cs.newLineAtOffset(160, n-360);
     cs.showText("Seventy Thousad Rupess only. ");
     cs.endText();
      
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(40,n-375);
     cs.showText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " );
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(350, n-390);
     cs.showText("Pervious Due           : ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(470, n-390);
     cs.showText("10000.00 ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(350, n-415);
     cs.showText("Total Amt ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 10);
     cs.newLineAtOffset(420, n-415);
     cs.showText("(Incl Due) ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(465, n-415);
     cs.showText(":");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(470, n-415);
     cs.showText("80000.00 ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(350, n-440);
     cs.showText("Amount Paid            : ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(470, n-440);
     cs.showText("75000.00 ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(350, n-465);
     cs.showText("Amount Due             : ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(470, n-465);
     cs.showText("5000.00 ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(350, n-490);
     cs.showText("Payment Mode        : ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font, 14);
     cs.newLineAtOffset(470, n-490);
     cs.showText("UPI ");
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(40,n-505);
     cs.showText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " );
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 14);
     cs.newLineAtOffset(200, n-520);
     cs.showText("THANKYOU!! PLEASE VIST AGAIN. ");
     cs.endText();
     
      cs.close();
         break;
         }
         
         System.out.print("Enter qnt");
         Double qnt= sc.nextDouble();
         
         System.out.print("Enter Mrp of 1");
         Double mrp= sc.nextDouble();
         
         System.out.print("Total Mrp");
         Double tmrp= sc.nextDouble();
         
         System.out.print("Net Amt");
         Double net= sc.nextDouble();
         
         System.out.print("Enter dis");
         Double dis= sc.nextDouble();
         
         System.out.print("Enter net after dis");
         Double netdis= sc.nextDouble();
         
         System.out.print("Enter tax%");
         Double tax= sc.nextDouble();
         
         System.out.print("Enter tax amt");
         Double taxamt= sc.nextDouble();
         
         System.out.print("Enter prc of 1");
         Double pof1= sc.nextDouble();
         
         System.out.print("Enter Total Prc");
         Double tp= sc.nextDouble();
         sc.nextLine();
         
         BillData bill=new BillData();
         
         productname = bill.nameDis();
         
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(30, n-20);
     cs.showText(productname);
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(140, n-20);
     cs.showText(qnt.toString());
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(180, n-20);
     cs.showText(mrp.toString());
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(220, n-20);
     cs.showText(tmrp.toString());
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(270, n-20);
     cs.showText(net.toString());
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(320, n-20);
     cs.showText(dis.toString());
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(360, n-20);
     cs.showText(netdis.toString());
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(410, n-20);
     cs.showText(tax.toString());
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(440, n-20);
     cs.showText(taxamt.toString());
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(490, n-20);
     cs.showText(pof1.toString());
     cs.endText();
     
     cs.beginText();
     cs.setFont(font1, 12);
     cs.newLineAtOffset(540, n-20);
     cs.showText(tp.toString());
     cs.endText();
     n=n-20;
     
     if(n<=40){
         m=m+1;
         creatpage(m);
     }
     }
        }catch(IOException e) {
        e.printStackTrace();
        }
    }
    
    
    public static void main(String args[])  {
        last pp = new last();
        pp.creatPdf();
       
    }
}
