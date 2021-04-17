package by.antonov.xmlparser.entity;

import java.time.LocalDate;

public class Newspaper extends Publication {
    private final String subscribeIndex;

    protected Newspaper(String id, String website, String title, LocalDate subscribeDate, String monthly, String colored, int pages, String subscribeIndex) {
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
        final StringBuilder sb = new StringBuilder("\r\nNewspaper{");
        sb.append(super.toString())
        .append(" subscribeIndex='").append(subscribeIndex).append("'")
        .append('}');
        return sb.toString();
    }

    public static class Builder {
        private String id;
        private String website = DEFAULT_WEBSITE;
        private String title;
        private LocalDate subscribeDate;
        private String monthly;
        private String colored;
        private int pages;
        private String subscribeIndex;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setSubscribeDate(LocalDate subscribeDate) {
            this.subscribeDate = subscribeDate;
            return this;
        }

        public Builder setMonthly(String monthly) {
            this.monthly = monthly;
            return this;
        }

        public Builder setColored(String colored) {
            this.colored = colored;
            return this;
        }

        public Builder setPages(int pages) {
            this.pages = pages;
            return this;
        }

        public Builder setSubscribeIndex(String subscribeIndex) {
            this.subscribeIndex = subscribeIndex;
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public Newspaper build() {
            return new Newspaper(id, website, title, subscribeDate, monthly, colored, pages, subscribeIndex);
        }
    }
}
