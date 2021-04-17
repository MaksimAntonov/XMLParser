package by.antonov.xmlparser.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class PublicationBuilderTest {
    @Test
    public void bookletBuilderTest() {
        Booklet.Builder bookletBuilder = new Booklet.Builder();
        bookletBuilder.setId("p-03").setWebsite("http://www.safelife.org/").setTitle("Safe Life")
                .setSubscribeDate(LocalDate.parse("2021-03-02")).setMonthly("No").setColored("Yes")
                .setPages(5).setPageType("Glossy");
        Booklet actual = bookletBuilder.build();
        Booklet expected = new Booklet("p-03","http://www.safelife.org/", "Safe Life",
                LocalDate.parse("2021-03-02"), "No", "Yes", 5, "Glossy");

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void magazineBuilderTest() {
        Magazine.Builder magazineBuilder = new Magazine.Builder();
        magazineBuilder.setId("p-12").setWebsite("http://www.carsandtruck.pub/").setTitle("Cars and Trucks")
                .setSubscribeDate(LocalDate.parse("2021-03-02")).setMonthly("Yes").setColored("No").setPages(15)
                .setSubscribeIndex("1-151-779").setPageType("Paper");
        Magazine actual = magazineBuilder.build();
        Magazine expected = new Magazine("p-12","http://www.carsandtruck.pub/","Cars and Trucks",
                LocalDate.parse("2021-03-02"),"Yes","No",15,"1-151-779",
                "Paper");

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void newspaperBuilderTest() {
        Newspaper.Builder newspaperBuilder = new Newspaper.Builder();
        newspaperBuilder.setId("p-001").setTitle("New York Time").setSubscribeDate(LocalDate.parse("2021-03-01"))
                .setMonthly("Yes").setColored("No").setPages(10).setSubscribeIndex("1-4516-705");
        Newspaper actual = newspaperBuilder.build();
        Newspaper expected = new Newspaper("p-001","http://www.example.com/","New York Time",
                LocalDate.parse("2021-03-01"),"Yes","No",10,"1-4516-705");

        Assert.assertEquals(actual, expected);
    }
}
