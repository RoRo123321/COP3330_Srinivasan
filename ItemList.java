import java.io.*;
import java.util.ArrayList;

/**
 * The type Contact list.
 */
public abstract class ItemList {
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Instantiates a new Contact list.
     */
    public ItemList() {
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return getItems().size();
    }

    /**
     * Gets contact items.
     *
     * @return the contact items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Add contact item.
     *
     * @param item the item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Gets contact item.
     *
     * @param index the index
     * @return the contact item
     * @throws Exception the exception
     */
    public Item getItem(int index) throws Exception {
        if (index < 0 || index >= items.size() ) {
            throw new Exception("Invalid contact number");
        }
        return items.get(index);
    }

    /**
     * Remove contact item.
     *
     * @param index the index
     * @throws Exception the exception
     */
    public void removeItem(int index) throws Exception {
        if (index < 0 || index >= items.size() ) {
            throw new Exception("Invalid contact number");
        }
        items.remove(index);
    }

    /**
     * Save current list.
     *
     * @param fileName the file name
     */
    public void saveCurrentList(String fileName) {
        try {
            File outFile = new File(fileName);
            FileOutputStream fos = new FileOutputStream(outFile);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (Item item : items) {
                String outStr = item.getItemAsLine("|") + "\n";
                bw.write(outStr);
            }
            bw.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
