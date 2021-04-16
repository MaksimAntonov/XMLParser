package by.antonov.xmlparser.entity;

import java.time.LocalDate;

public class Magazine extends Newspaper{
    private String pageType;

    private Magazine(String id, String website, String title, LocalDate subscribeDate, String monthly, String colored, int pages, String subscribeIndex, String pageType) {
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

    public static class Builder {
        private String id;
        private String title;
        private LocalDate subscribeDate;
        private String monthly;
        private String colored;
        private int pages;
        private String subscribeIndex;
        private String pageType;
        private String website = DEFAULT_WEBSITE;

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

        public Builder setPageType(String pageType) {
            this.pageType = pageType;
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public Magazine build() {
            return new Magazine(id, website, title, subscribeDate, monthly, colored, pages, subscribeIndex, pageType);
        }
    }
}
