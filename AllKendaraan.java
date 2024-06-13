public class AllKendaraan {
    Kendaraan head, tail;
    int size;

    private boolean isEmpty() {
        return head == null;
    }

    public void add(String noTNKB, String nama, String jenis, int cc, int tahun, int bulanHarusBayar) {
        if (isEmpty()) {
            head = tail = new Kendaraan(null, noTNKB, nama, jenis, cc, tahun, bulanHarusBayar, null);
        } else if (size == 0) {
            Kendaraan temp = new Kendaraan(null, noTNKB, nama, jenis, cc, tahun, bulanHarusBayar, null);
            head.next = temp;
            temp.prev = head;
        } else {
            Kendaraan temp = new Kendaraan(null, noTNKB, nama, jenis, cc, tahun, bulanHarusBayar, null);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
    }

    public Kendaraan checkAvailability(String inputNoTNKB) {
        if (!isEmpty()) {
            Kendaraan temp = tail;
            while (temp != null) {
                if (temp.noTNKB.equals(inputNoTNKB)) {
                    return temp;
                }
                temp = temp.prev;
            }
        }
        return null;
    }

    public void print() {
        Kendaraan temp = head;
        System.out.println(
            "+++++++++++++++++++++++++\n" +
            "Daftar Kendaraan\n" +
            "+++++++++++++++++++++++++\n" +
            "| Nomor TNKB \t| Nama Pemilik\t| Jenis\t| CC Kendaraan\t| Tahun\t| Bulan harus bayar"
        );
        while (temp != null) {
            System.out.printf("| %s\t| %s\t\t| %s\t| %d\t\t| %d\t| %d\n", temp.noTNKB, temp.nama, temp.jenis, temp.cc, temp.tahun, temp.bulanHarusBayar);
            temp = temp.next;
        }
    }
}
