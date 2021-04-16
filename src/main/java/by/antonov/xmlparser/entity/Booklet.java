package by.antonov.xmlparser.entity;

import java.time.LocalDate;

public class Booklet extends Publication{
    private String pageType;

    public Booklet(String id, String website, String title, LocalDate subscribeDate, String monthly, String colored, int pages, String pageType) {
        super(id, website, title, subscribeDate, monthly, colored, pages);
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
        final StringBuilder sb = new StringBuilder("\r\nBooklet{");
        sb.append(super.toString());
        sb.append(" pageType='").append(pageType).append("'");
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {
        private String id;
        private String website;
        private String title;
        private LocalDate subscribeDate;
        private String monthly;
        private String colored;
        private int pages;
        private String pageType;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
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

        public Builder setPageType(String pageType) {
            this.pageType = pageType;
            return this;
        }

        public Booklet build() {
            return new Booklet(id, website, title, subscribeDate, monthly, colored, pages, pageType);
        }
    }
}
