package src;
public class Kendaraan {
    String noTNKB, nama, jenis;
    int cc, tahun, bulanHarusBayar;
    Kendaraan prev, next;

    public Kendaraan(Kendaraan prev, String noTNKB, String nama, String jenis, int cc, int tahun, int bulanHarusBayar, Kendaraan next) {
        this.noTNKB = noTNKB;
        this.nama = nama;
        this.jenis = jenis;
        this.cc = cc;
        this.tahun = tahun;
        this.bulanHarusBayar = bulanHarusBayar;
        this.prev = prev;
        this.next = next;
    }
}
