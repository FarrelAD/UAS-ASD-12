public class AntrianPajak {
    TransaksiPajak head, tail;
    AllKendaraan allKdr;
    int kode = 1;

    public AntrianPajak(AllKendaraan dataKendaraan) {
        allKdr = dataKendaraan;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void addNewTransaction(String noTNKB, int inputBulanBayar) {
        // Mengecek keberadaan kendaraan
        Kendaraan kdr = allKdr.checkAvailability(noTNKB);
        if (kdr == null) {
            System.out.println("Data kendaraan tidak ditemukan! Coba ulangi input!");
        } else {
            // Menghitung nominal pajak
            long totalBayarPajak = 0;
            int ccKendaraan = kdr.cc;
            if (kdr.jenis.equals("Motor")) {
                if (ccKendaraan < 100) {
                    totalBayarPajak += 100000;
                } else if (ccKendaraan >= 100 && ccKendaraan <= 250) {
                    totalBayarPajak += 250000;
                } else  {
                    totalBayarPajak += 500000;
                }
            } else {
                if (ccKendaraan < 1000) {
                    totalBayarPajak += 750000;
                } else if (ccKendaraan >= 1000 && ccKendaraan <= 2500) {
                    totalBayarPajak += 1000000;
                } else {
                    totalBayarPajak += 1500000;
                }
            }

            // Menghitung denda pajak
            int bulanBayar = kdr.bulanHarusBayar;
            int denda = 0;
            int telatBerapaBulan = inputBulanBayar - bulanBayar;
            if (bulanBayar < inputBulanBayar) {
                if (telatBerapaBulan <= 3) {
                    denda += 50000;
                } else {
                    // int telatBulanKhusus = telatBerapaBulan - 3;
                    denda += (50000 * telatBerapaBulan);
                }
            }

            totalBayarPajak += denda;

            // Menambahkan data transaksi terbaru
            if (isEmpty()) {
                head = new TransaksiPajak(null, kode, totalBayarPajak, denda, inputBulanBayar, kdr, null);
                kode++;
            } else {
                TransaksiPajak temp = new TransaksiPajak(null, inputBulanBayar, ccKendaraan, denda, bulanBayar, kdr, head);
                head.prev = temp;
                head = temp;
                kode++;
            }

            System.out.println("kode\t| TNKB\t\t| Nama\t| Nominal\t\t| Denda");
            System.out.println(head.kode + "\t|" + head.kendaraan.noTNKB + "\t|" + head.kendaraan.nama + "\t|" + head.nominalBayar + "\t\t\t|" + head.denda);
        }
    }

    public void print() {

    }
}
