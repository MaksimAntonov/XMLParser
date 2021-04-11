package by.antonov.xmlparser.entity;

import java.time.LocalDate;

public class Booklet extends Publication{
    private String pageType;

    public Booklet(String id, String title, LocalDate subscribeDate, String monthly, String colored, int pages, String pageType) {
        super(id, title, subscribeDate, monthly, colored, pages);
        this.pageType = pageType;
    }

    public Booklet(String id, String website, String title, LocalDate subscribeDate, String monthly, String colored, int pages, String pageType) {
        super(id, website, title, subscribeDate, monthly, colored, pages);
        this.pageType = pageType;
    }

    public String getPageType() {
        return pageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booklet)) return false;
        if (!super.equals(o)) return false;

        Booklet booklet = (Booklet) o;
        return (getPageType() != null && getPageType().equals(booklet.getPageType()));
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getPageType() != null ? getPageType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Booklet{");
        sb.append("pageType='").append(pageType).append("'");
        sb.append('}');
        return sb.toString();
    }
}
