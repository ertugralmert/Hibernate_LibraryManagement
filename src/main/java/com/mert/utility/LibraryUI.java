package com.mert.utility;

import com.mert.controller.UserController;

public class LibraryUI {
    UserController userController;

    public LibraryUI() {
        this.userController=new UserController();
    }

    public  void mainMenu(){
        System.out.println("====KÜTÜPHANE YÖNETİM SİSTEMİ");
        System.out.println("1-Kayıt ol");
        System.out.println("2-Giriş yap");
        System.out.println("0-Çıkış yap");
    }

    public void  userMenu(){
        System.out.println("1-Profil bilgilerini guncelle");
        System.out.println("2-Kitap listele");
        System.out.println("3-Kitap kirala");
        System.out.println("4-Yazarları listele");
    }

    public  void  startApp(){

        int control;
        do {
            mainMenu();
            control=ScannerQuestions.intDegerAlma("lütfen bir secim yapınız");
            switch (control){
                case 1:
                    userController.save();
                    break;
                case 2:
                    userController.login();
                    break;
                case 0:
                    System.out.println("Program sonlanıyor....");
                    break;
                default:
                    break;

            }


        }while (control!=0);



    }
}
