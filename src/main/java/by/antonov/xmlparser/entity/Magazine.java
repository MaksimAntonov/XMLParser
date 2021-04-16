package by.antonov.xmlparser.entity;

import java.time.LocalDate;

public class Magazine extends Newspaper{
    private String pageType;

    public Magazine() {
        super();
    }

    public Magazine(String id, String title, LocalDate subscribeDate, String monthly, String colored, int pages, String subscribeIndex, String pageType) {
        super(id, title, subscribeDate, monthly, colored, pages, subscribeIndex);
        this.pageType = pageType;
    }

    public Magazine(String id, String website, String title, LocalDate subscribeDate, String monthly, String colored, int pages, String subscribeIndex, String pageType) {
        super(id, website, title, subscribeDate, monthly, colored, pages, subscribeIndex);
        this.pageType = pageType;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;
        if (!super.equals(o)) return false;

        Magazine magazine = (Magazine) o;
        return (getPageType().equals(magazine.getPageType()));
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + ((getPageType() != null) ? getPageType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\r\nMagazine{");
        sb.append(super.toString());
        sb.append(" pageType='").append(pageType).append("'");
        sb.append('}');
        return sb.toString();
    }
}
