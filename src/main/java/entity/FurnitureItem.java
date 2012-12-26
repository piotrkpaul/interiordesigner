package entity;

/**
 * Date: 25.12.2012
 * Time: 22:38
 */
public class FurnitureItem {

    private String id;
    private int x;
    private int y;
    private int width;
    private int height;

    public FurnitureItem(String id, int x, int y, int width, int height) {
        this.height = height;
        this.id = id;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + id + "," + x + "," + y + "," + width + "," + height + "}";

    }
}
