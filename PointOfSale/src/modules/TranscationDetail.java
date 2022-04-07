package modules;

public class TranscationDetail {
    private int quantity = 0;
    private Item item = new Item();

    public TranscationDetail() {
    }

    public TranscationDetail(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
