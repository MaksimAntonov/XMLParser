package by.antonov.xmlparser.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Newspaper extends Publication {
    private String subscribeIndex;

    public Newspaper(String id, String title, LocalDate subscribeDate, String monthly, String colored, int pages, String subscribeIndex) {
        super(id, title, subscribeDate, monthly, colored, pages);
        this.subscribeIndex = subscribeIndex;
    }

    public Newspaper(String id, String website, String title, LocalDate subscribeDate, String monthly, String colored, int pages, String subscribeIndex) {
        super(id, website, title, subscribeDate, monthly, colored, pages);
        this.subscribeIndex = subscribeIndex;
    }

    public String getSubscribeIndex() {
        return subscribeIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Newspaper)) return false;
        if (!super.equals(o)) return false;

        Newspaper newspaper = (Newspaper) o;
        return (getSubscribeIndex() != null && getSubscribeIndex().equals(newspaper.getSubscribeIndex()));
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getSubscribeIndex() != null ? getSubscribeIndex().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Newspaper{" + super.toString() + "subscribeIndex='" + subscribeIndex + "'}";
    }
}
