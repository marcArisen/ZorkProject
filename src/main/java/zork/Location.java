package zork;

import zork.actors.Monster;
import zork.items.Item;

public class Location {

    // Row and column positions.
    private Location left;
    private Location right;
    private Location up;
    private Location down;
    private String nameOfLocation;
    private Monster monster;
    private Item item;

    public Location(String name) {
        this.nameOfLocation = name;
    }

    public void setDown(Location down) {
        this.down = down;
    }

    public void setUp(Location up) {
        this.up = up;
    }

    public void setRight(Location right) {
        this.right = right;
    }

    public void setLeft(Location left) {
        this.left = left;
    }

    public Location getLeft() {
        if (this.left==null){
            return NullLocation.getInstance();
        }
        return left;
    }

    public Location getRight() {
        if (this.right==null){
            return NullLocation.getInstance();
        }
        return right;
    }

    public Location getUp() {
        if (this.up==null){
            return NullLocation.getInstance();
        }
        return up;
    }

    public Location getDown() {
        if (this.down==null){
            return NullLocation.getInstance();
        }
        return down;
    }

    public String getNameOfLocation() {
        return nameOfLocation;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void removeMonster(){
        this.monster = null;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

}
