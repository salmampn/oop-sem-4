package uas_praktik_oop_gl;

public class salma_Order {
    private int orderId;
    private salma_Customer customer;
    private salma_Item itemTerpilih;
    private int qtyItem;
    private double totalHarga;

    public salma_Order(int orderId, salma_Customer customer, salma_Item itemTerpilih, int qtyItem, double totalHarga) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemTerpilih = itemTerpilih;
        this.qtyItem = qtyItem;
        this.totalHarga = totalHarga;
    }

    public int getOrderId() {
        return orderId;
    }

    public String printDetailOrder() {
        return "Order ID: " + orderId + "\n" + "Nama Pelanggan: " + customer.getNama() + "\n" + "Barang: "
                + itemTerpilih.getNama() + "\nJumlah: "
                + qtyItem + "\nTotal Harga: " + totalHarga;
    }

}
