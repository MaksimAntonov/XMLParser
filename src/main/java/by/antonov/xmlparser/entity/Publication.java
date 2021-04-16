package by.antonov.xmlparser.entity;

import java.time.LocalDate;

public abstract class Publication {
    protected static final String DEFAULT_WEBSITE = "http://www.example.com";

    private String id;
    private String website;
    private String title;
    private LocalDate subscribeDate;
    private String monthly;
    private String colored;
    private int pages;

    public Publication(String id, String title, LocalDate subscribeDate, String monthly, String colored, int pages) {
        this(id, DEFAULT_WEBSITE, title, subscribeDate, monthly, colored, pages);
    }

    public Publication(String id, String website, String title, LocalDate subscribeDate, String monthly, String colored, int pages) {
        this.id = id;
        this.website = website;
        this.title = title;
        this.subscribeDate = subscribeDate;
        this.monthly = monthly;
        this.colored = colored;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public String getWebsite() {
        return website;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getSubscribeDate() {
        return subscribeDate;
    }

    public String getMonthly() {
        return monthly;
    }

    public String getColored() {
        return colored;
    }

    public int getPages() {
        return pages;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubscribeDate(LocalDate subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public void setMonthly(String monthly) {
        this.monthly = monthly;
    }

    public void setColored(String colored) {
        this.colored = colored;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;

        Publication that = (Publication) o;
        return getPages() == that.getPages()
                && (getTitle() != null && getTitle().equals(that.getTitle()))
                && (getSubscribeDate() != null && getSubscribeDate().equals(that.getSubscribeDate()))
                && (getMonthly() != null && getMonthly().equals(that.getMonthly()))
                && (getId() != null && getId().equals(that.getId()))
                && (getColored() != null && getColored().equals(that.getColored()));
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getWebsite() != null ? getWebsite().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getSubscribeDate() != null ? getSubscribeDate().hashCode() : 0);
        result = 31 * result + (getMonthly() != null ? getMonthly().hashCode() : 0);
        result = 31 * result + (getColored() != null ? getColored().hashCode() : 0);
        result = 31 * result + getPages();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Publication{");
        sb.append("id='").append(id).append("'");
        sb.append(", website='").append(website).append("'");
        sb.append(", title='").append(title).append("'");
        sb.append(", subscribeDate=").append(subscribeDate);
        sb.append(", monthly='").append(monthly).append("'");
        sb.append(", colored='").append(colored).append("'");
        sb.append(", pages=").append(pages);
        sb.append('}');
        return sb.toString();
    }
}
