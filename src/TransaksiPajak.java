package src;
public class TransaksiPajak {
    int kode, bulanBayar;
    long nominalBayar, denda;
    Kendaraan kendaraan;
    TransaksiPajak prev, next;

    public TransaksiPajak(TransaksiPajak prev, int kode, long nominalBayar, long denda, int bulanBayar, Kendaraan kendaraan, TransaksiPajak next) {
        this.kode = kode;
        this.nominalBayar = nominalBayar;
        this.denda = denda;
        this.bulanBayar = bulanBayar;
        this.kendaraan = kendaraan;
        this.prev = prev;
        this.next = next;
    }
}