package hungnguyen.nth.eventhandling.model;

public class Tenology {
    private int img;
    private String name,sub,des;

    public Tenology(int img, String name, String sub, String des) {
        this.img = img;
        this.name = name;
        this.sub = sub;
        this.des = des;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
