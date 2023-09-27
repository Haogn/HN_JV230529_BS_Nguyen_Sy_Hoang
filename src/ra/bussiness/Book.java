package ra.bussiness;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Book {
    private static int nextId = 1 ;
    private int bookId ;
    private String bookName ;
    private String author ;
    private String descriptions;
    private double importPrice ;
    private double exportPrice ;
    private float interest ;
    private boolean bookStatus ;

    public Book() {
        this.bookId = nextId++;
        this.bookStatus = true ;
        this.interest = (float) (exportPrice- importPrice) ;
    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.bookStatus = bookStatus;


    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void calProfit(){
        this.interest = (float)(exportPrice - importPrice)  ;
    }

    public void inputData(Scanner sc) {
//        System.out.println("Nhap vao ma sach ");
//        this.bookId = Integer.parseInt(sc.nextLine()) ;

        // ten sach khong dc de trong
//        boolean checkName = true ;
        while (true) {
            System.out.println("Nhap vap ten sach ");
            String name = sc.nextLine();
            if (name.isEmpty()) {
                System.err.println("Ten sach khong duoc de trong");
            } else {
               this.bookName = name ;
//               checkName = false ;
               break;
            }
        }

        // ten tac gia khong dc de trong
//        boolean checkAuthor = true ;
        while (true) {
            System.out.println("Nhap vao ten tac gia ");
            String tacgia = sc.nextLine();
            if (tacgia.isEmpty()) {
                System.err.println("Ten tac gia khong duoc de trong ");
            } else {
                this.author = tacgia ;
//                checkAuthor = false ;
                break;
            }
        }

        // mo ta san pham it nhat 10 ky tu
//        boolean checkDesci = true ;
        while (true) {
            System.out.println("Mo ta san pham ");
            String mota = sc.nextLine();
            if (!mota.matches("^[a-zA-Z0-9]{10,}$")) {
                this.descriptions = mota ;
//                checkDesci = false ;
                break;
            } else {
                System.err.println("Mo ta san pham phai it nhat 10 ky tu, Vui long nhap lai ❤ ");
            }
        }

        // Gia nhap  importPrice > 0
        while (true) {
            System.out.println("Gia nhap vao ");
            double priceImport = Double.parseDouble(sc.nextLine()) ;
            if (priceImport <= 0) {
                System.err.println("Gia nhap co loi, vui long nhap lai ❤");
            } else {
                this.importPrice = priceImport ;
                break;
            }
        }

        // Gia ban ra phai lon hon 1.2 lan gia nhap
        while (true) {
            System.out.println("Gia ban ra ");
            double priceExport = Double.parseDouble(sc.nextLine()) ;
            if (priceExport < (importPrice * 1.2)) {
                System.err.println("Gia ban ra chua hop ly, Vui long nhap lai ❤");
            } else {
                this.exportPrice = priceExport ;
                break;
            }
        }

        //
    }



    public void displayData() {
        System.out.println("____________ THÔNG TIN SÁCH ___________ ");
        System.out.println("Mã sản phẩm: " + bookId);
        System.out.println("Tên sản phẩm: " + bookName);
        System.out.println("Tên tác giá: " + author);
        System.out.println("Mô tả sách: " + descriptions);
        System.out.printf("Giá nhập vào: %.1f VND\n" , importPrice );
        System.out.printf("Giá bán ra: %.1f VND\n" , exportPrice);
        System.out.println("Lợi nhuận: " + interest + " VND" );
        System.out.println("Trạng thái: " + (bookStatus?"Mo ban":"Khong ban"));
    }

}
