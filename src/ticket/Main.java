/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

import java.util.Scanner;

/**
 *
 * @author 4d3h3
 */
public class Main {
    
    public static void main(String[] args) {
        /**
         * Membuat array / list untuk tiket-tiket yang ada di aplikasi
         * Tipe data menggunakan interface Ticket
         * 
         * new Economy/Business/Executive adalah deklarasi objek dengan class
         * tersebut (Economy/Business/Executive)
         */
        Ticket[] tickets = {
            new Economy("Ekonomi"),
            new Business("Bisnis"),
            new Executive("Eksekutif")
        };
        
        /**
         * Menjalankan method start (Memulai aplikasinya)
         */
        start(tickets);
    }
    
    public static void start(Ticket[] tickets) {
        /**
         * Deklarasi variabel boolean stop agar sistem tahu kapan untuk berhenti
         * apabila stop = true aplikasi berhenti
         * kalau false aplikasi akan lanjut membuat transaksi berikutnya
         */
        boolean stop = false;
        
        /**
         * Perulangan aplikasi yang diulangi terus selama user menginginkan untuk
         * membuat transaksi lainnya
         */
        while (!stop) {
            /**
             * Mengoutput / mengeprint list tiket berdasarkan array tiket yang diatas
             * tahan ctrl dan klik fungsi nya untuk melihat
             */
            printTicketList(tickets);

            /**
             * Deklarasi variabel scanner untuk input data transaksinya
             * variabel ticketIndex berisi index tiket yang diisi
             * variabel quantity berisi jumlah penumpang / jumlah tiket yang
             * dibeli
             * variabel price berisi nilai harga tiket tersebut
             */
            Scanner input = new Scanner(System.in);
            int ticketIndex, quantity = 0, price;
            String again;

            /**
             * Print pertanyaan input data
             */
            System.out.println("Masukkan Pesanan Anda");
            System.out.print("Kelas = ");
                
                while (!input.hasNextInt()) {
                    System.out.println("Masukkan nomor kelas berupa angka!");
                    System.out.print("Kelas = ");
                   
                    input.next();
                }

            ticketIndex = input.nextInt();
            
            /**
             * Validasi apabila nomor tiket yang dimasukkan tidak sesuai
             */
            if (ticketIndex <= 0 || ticketIndex > tickets.length) {
                System.out.println("=================");
                
                System.out.println("Tolong masukkan nomor tiket sesuai list!");
                
                continue;
            }
            
            while(quantity <= 0) {
                System.out.print("Jumlah Penumpang = ");
                
                while (!input.hasNextInt()) {
                    System.out.println("Masukkan jumlah penumpang berupa angka!");
                    System.out.print("Jumlah Penumpang = ");
                   
                    input.next();
                }
                
                quantity = input.nextInt();
            }

            int total = tickets[ticketIndex - 1].getPrice() * quantity;

            /**
             * Output / print total yang harus dibayar oleh pembeli
             */
            System.out.println("Total Bayar = " + total);
            
            System.out.println("=================");
            
            /**
             * Deklarasi variabel boolean stopAsk agar sistem tahu kapan untuk berhenti
             * bertanya tentang lanjut transaksi atau tidak
             * Bila diisi "y" aplikasi akan melanjutkan ke transaksi selanjutnya
             * Bila diisi "n" aplikasi akan berhenti
             * Bila diisi selain "y" / "n" aplikasi akan lanjut menanyakan lanjut atau tidak
             */
            boolean stopAsk = false;
            
            while (!stopAsk) {
                System.out.println("Pesan Tiket Lagi? (Y/N) ");

                again = input.next();

                if (!again.toLowerCase().equals("y") && !again.toLowerCase().equals("n")) {
                    continue;
                }
                
                stopAsk = true;
                
                if (again.toLowerCase().equals("n")) {
                    stop = true;
                }
            }
        }
    }
    
    public static void printTicketList(Ticket[] tickets) {
        System.out.println("=================");
        System.out.println("List Tiket Kereta");
        
        for (int i = 0; i < tickets.length; i++) {
            System.out.println((i + 1) + ". " + tickets[i].getName() + " : " + tickets[i].getPrice());
        }
        
        System.out.println("=================");
    }
    
}
