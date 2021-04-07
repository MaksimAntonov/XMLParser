package by.antonov.xmlparser.entity;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Publication {
    private static String DEFAULT_WEBSITE = "http://www.example.com";

    private String id;
    private String website;
    private String title;
    private LocalDate subscribeDate;
    private String monthly;
    private String colored;
    private int pages;

    public Publication(String id, String title, LocalDate subscribeDate, String monthly, String colored, int pages) {
        this.id = id;
        this.website = DEFAULT_WEBSITE;
        this.title = title;
        this.subscribeDate = subscribeDate;
        this.monthly = monthly;
        this.colored = colored;
        this.pages = pages;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        Publication that = (Publication) o;
        return getPages() == that.getPages()
                && (id != null && getId().equals(that.getId()))
                && (title != null && getTitle().equals(that.getTitle()))
                && (subscribeDate != null && getSubscribeDate().equals(that.getSubscribeDate()))
                && (monthly != null && getMonthly().equals(that.getMonthly()))
                && (colored != null && getColored().equals(that.getColored()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getSubscribeDate(), getMonthly(), getColored(), getPages());
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id='" + id + '\'' +
                (website != null ? ", website='" + website + "'" : "") +
                ", title='" + title + "'" +
                ", subscribeDate=" + subscribeDate +
                ", monthly='" + monthly + '\'' +
                ", colored='" + colored + '\'' +
                ", pages=" + pages +
                '}';
    }
}
