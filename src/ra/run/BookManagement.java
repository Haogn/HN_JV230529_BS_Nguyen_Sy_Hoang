package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    Book[] arrBook = new Book[100] ;
    int currenIndex = 0 ;
//    Book book1 = new Book(1,"Truyện Kiều","Nguyễn DU", "Số phận người con gái xã hội phong kiến", 50000, 100000,true )
//    Book book2 = new Book(3,"Chí phèo","Văn Cao", "Số phận người nông đân xã hội phong kiến", 60000, 120000,true );

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in) ;
        BookManagement bookManagement = new BookManagement();
        int choice ;
        do {
            System.out.println("____________ JAVA-HACKATHON-05-BASIC-MENU _____________");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. ❌ Thoát");
            System.out.println("Lựa chọn từ 1-7 để thực hiện chức năng");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 :
                    // thêm sách
                    bookManagement.createBook(sc);
                    break;
                case 2 :
                    // hiển thị thông tin sách trong thư viện
                    bookManagement.printBook();
                    break;
                case 3 :
                    // sắp xếp theo giá tăng dần
                    bookManagement.sortByPrice();
                    break;
                case 4 :
                    // xoá sách khỏi danh mục
                    bookManagement.deleteBook(sc);
                    break;
                case 5 :
                    // tìm kiếm sách theo tên hoặc mô tả
                    bookManagement.searchByNameOrDescriptions(sc);
                    break;
                case 6 :
                    // thay đổi thông tin sách theo id
                    bookManagement.updateBookById(sc);
                    break;
                case 7 :
                    System.out.println("❤🤞🏻 Thoát khỏi chương trình");
                    sc.close();
                    break;
                default:
                    System.err.println("Lựa chọn chức năng không phù hợp , vui lòng nhâp lại ");
            }
        } while (choice != 7) ;
    }
     public void createBook(Scanner sc) {
         System.out.println("Nhập vào số lượng sách muôn thêm");
         int add = Integer.parseInt(sc.nextLine()) ;
         for (int i = 0; i < add; i++) {
             arrBook[currenIndex] = new Book() ;
             arrBook[currenIndex].inputData(sc);
             currenIndex++ ;
         }
         System.out.println("Đã thêm sách vào danh mục");
     }


     public void printBook() {
         for (int i = 0; i < currenIndex; i++) {
             arrBook[i].displayData();
         }
     }

     public void sortByPrice() {
         for (int i = 0; i < currenIndex - 1; i++) {
             for (int j = i + 1; j < currenIndex; j++) {
                 if (arrBook[i].getInterest() > arrBook[j].getInterest()) {
                     Book temp = arrBook[i];
                     arrBook[i] = arrBook[j];
                     arrBook[j] = temp;
                 }
             }
         }
         System.out.println("Sap xep cac san pham theo loi nhuan giam dan ");
         for (int i = 0; i < currenIndex; i++) {
             arrBook[i].calProfit();
             System.out.println(arrBook[i].getBookName() + " " +  arrBook[i].getInterest() + "VND/sp");
         }
     }

    public int searchById(int idBook) {

        for (int i = 0; i < currenIndex; i++) {
            if (arrBook[i].getBookId() == idBook){
                return i;
            }
        }
        return -1 ;
    }

    public void deleteBook(Scanner sc) {
        System.out.println("Nhập vào mã sách cần xoá");
        int idDelete = Integer.parseInt(sc.nextLine()) ;
        int foundIndex = searchById(idDelete) ;
        if (foundIndex >= 0 ) {
            for (int i = foundIndex; i < currenIndex-1; i++) {
                arrBook[i] = arrBook[i+1];
            }
            arrBook[currenIndex-1] = null;
            currenIndex--;
        } else {
            System.err.println("Không tìm thấy sách trong danh mục");
        }

    }

    public void searchByNameOrDescriptions(Scanner sc) {
        System.out.println("Nhập tên sách hoặc mô tả cần tìm kiếm");
        String search = sc.nextLine() ;
        for (int i = 0; i < currenIndex; i++) {
            if (arrBook[i].getBookName().equalsIgnoreCase(search) || arrBook[i].getDescriptions().equalsIgnoreCase(search)) {
                System.out.println("Sách tìm thấy theo tên hoặc mô tả trong trong danh lục là " + arrBook[i].getBookName());
                break;
            } else {
                System.err.println("Không tìm thấy sách theo tên hoặc mô tả");
            }
        }
    }

    public void updateBookById(Scanner sc) {
        System.out.println("Nhập vào mã sách cần thay đổi thông tin");
        int idUpdate = Integer.parseInt(sc.nextLine());
        int foundIndex = searchById(idUpdate);

        if (foundIndex >= 0) {
            //Nhập thông tin cập nhật
            System.out.println("Nhập vào tên sách cần cập nhật:");
            String nameBook = sc.nextLine();
            if (!nameBook.trim().isEmpty()) {
                arrBook[foundIndex].setBookName(nameBook);
            }

            System.out.println("Nhập vào tên tác giả cần cập nhật:");
            String tacgia = sc.nextLine();
            if (!tacgia.trim().isEmpty()) {
                arrBook[foundIndex].setAuthor(tacgia);
            }

            System.out.println("Nhập vào mô tả sách cần cập nhật:");
            String mota = sc.nextLine();
            if (!mota.trim().isEmpty()) {
                while (mota.length() <= 10) {
                    System.err.println("Mô tả sản phẩm ít nhất 10 ký tự, vui lòng nhập lại:");
                    mota = sc.nextLine();
                }
                arrBook[foundIndex].setDescriptions(mota);
            }

            System.out.println("Giá nhập vào cần cập nhật:");
            String priceImport = sc.nextLine();
            if (!priceImport.trim().isEmpty()) {
                double importPrice = Double.parseDouble(priceImport);
                while (importPrice <= 0) {
                    System.err.println("Giá nhập vào chưa hợp lệ, vui lòng nhập lại:");
                    priceImport = sc.nextLine();
                    importPrice = Double.parseDouble(priceImport);
                }
                arrBook[foundIndex].setImportPrice(importPrice);
            }

            System.out.println("Giá bán ra cần cập nhật:");
            String priceExport = sc.nextLine();
            if (!priceExport.trim().isEmpty()) {
                double exportPrice = Double.parseDouble(priceExport);
                while (exportPrice < arrBook[foundIndex].getImportPrice() * 1.2) {
                    System.err.println("Giá bán ra phải ít nhất 1.2 lần giá nhập, vui lòng nhập lại:");
                    priceExport = sc.nextLine();
                    exportPrice = Double.parseDouble(priceExport);
                }
                arrBook[foundIndex].setExportPrice(exportPrice);
            }
        } else {
            System.err.println("Không tìm thấy sách trong danh mục");
        }
    }

}
