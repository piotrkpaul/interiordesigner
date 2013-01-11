package entity;

import org.codehaus.jackson.annotate.JsonAnySetter;

/**
 * Date: 25.12.2012
 * Time: 22:38
 */
public class FurnitureItem {

    private String id;
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;

    @JsonAnySetter
    public void handleUnknown(String key, Object value) {
        System.out.println(key + " " + value.toString());
    }

    public FurnitureItem(String id, Integer x, Integer y, Integer width, Integer height) {
        this.height = height;
        this.id = id;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public FurnitureItem(){}

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + id + "," + x + "," + y + "," + width + "," + height + "}";

    }
}
