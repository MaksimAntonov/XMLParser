package by.antonov.xmlparser.entity;

import java.time.LocalDate;

public class Magazine extends Publication{
    private String subscribeIndex;
    private String pageType;

    public Magazine(String id, String title, LocalDate subscribeDate, String monthly, String colored, int pages, String subscribeIndex, String pageType) {
        super(id, title, subscribeDate, monthly, colored, pages);
        this.subscribeIndex = subscribeIndex;
        this.pageType = pageType;
    }

    public Magazine(String id, String website, String title, LocalDate subscribeDate, String monthly, String colored, int pages, String subscribeIndex, String pageType) {
        super(id, website, title, subscribeDate, monthly, colored, pages);
        this.subscribeIndex = subscribeIndex;
        this.pageType = pageType;
    }

    public String getSubscribeIndex() {
        return subscribeIndex;
    }

    public String getPageType() {
        return pageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;
        if (!super.equals(o)) return false;

        Magazine magazine = (Magazine) o;
        return (getSubscribeIndex().equals(magazine.getSubscribeIndex()) && getPageType().equals(magazine.getPageType()));
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getSubscribeIndex().hashCode();
        result = 31 * result + getPageType().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Magazine{" + super.toString()
                + "subscribeIndex='" + subscribeIndex +
                "', pageType='" + pageType + "'} ";
    }
}
