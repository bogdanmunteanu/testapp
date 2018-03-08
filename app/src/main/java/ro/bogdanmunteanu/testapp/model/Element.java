package ro.bogdanmunteanu.testapp.model;


public class Element {
    private int number;

    private String pictureUrl;

    public Element(int number, String pictureUrl) {
        this.number = number;
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Element{");
        sb.append("number=").append(number);
        sb.append(", pictureUrl='").append(pictureUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
