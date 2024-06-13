import java.util.Scanner;;

public class MainPajak {
    static Scanner sc12 = new Scanner(System.in);
    public static void main(String[] args) {
        // Menammbahkan data kendaraan
        // FITUR MENU 1 - DONE!
        AllKendaraan kdr = new AllKendaraan();
        kdr.add("S 4567 YV", "Basko", "Mobil", 2000, 2012, 4);
        kdr.add("N 4511 VS", "Arta", "Mobil", 2500, 2015, 3);
        kdr.add("AB 4321 A", "Wisnu", "Motor", 125, 2010, 2);
        kdr.add("B 1234 AG", "Sisa", "Motor", 150, 2020, 1);

        AntrianPajak atrPajak = new AntrianPajak(kdr);


        menu();
        int selectedMenu = sc12.nextInt();
        sc12.nextLine();
        switch (selectedMenu) {
            case 1:
                kdr.print();
                break;
            case 2:
                bayarPajak(atrPajak);
                break;
            default:
                System.out.println("INPUT INVALID!");
                break;
        }
    }

    private static void menu() {
        System.out.print(
            "Menu:\n" +
            "1. Daftar kendaraan\n" +
            "2. Bayar pajak\n" +
            "3. Tampilkan seluruh transaksi\n" +
            "4. Urutkan transaksi berdasarkan nama pemilik\n" +
            "5. Keluar\n" +
            "Pilih (1-5) : "
        );
    }

    private static void bayarPajak(AntrianPajak atrPajak) {
        System.out.print("Masukkan nomor TNBK: ");
        String inputTNBK = sc12.nextLine();
        System.out.print("Bulan bayar: ");
        int inputBulanBayar = sc12.nextInt();
        sc12.nextLine();
        atrPajak.addNewTransaction(inputTNBK, inputBulanBayar);
    }
}
