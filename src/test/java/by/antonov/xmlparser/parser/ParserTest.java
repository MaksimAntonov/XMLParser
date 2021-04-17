package by.antonov.xmlparser.parser;

import by.antonov.xmlparser.entity.Booklet;
import by.antonov.xmlparser.entity.Magazine;
import by.antonov.xmlparser.entity.Newspaper;
import by.antonov.xmlparser.entity.Publication;
import by.antonov.xmlparser.exception.PublicationException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ParserTest {
    private final String PAPERS_XML_FILE = "data/papers_test.xml";
    private Set<Publication> expectedSet;

    @BeforeClass
    public void beforeClass() {
        expectedSet = new HashSet<>();
        Magazine.Builder magazineBuilder = new Magazine.Builder();
        magazineBuilder.setId("p-12").setWebsite("http://www.carsandtruck.pub/").setTitle("Cars and Trucks")
                .setSubscribeDate(LocalDate.parse("2021-03-02")).setMonthly("Yes").setColored("No").setPages(15)
                .setPageType("Paper").setSubscribeIndex("1-151-779");
        expectedSet.add(magazineBuilder.build());

        Newspaper.Builder newspaperBuilder = new Newspaper.Builder();
        newspaperBuilder.setId("p-001").setTitle("New York Time").setSubscribeDate(LocalDate.parse("2021-03-01"))
                .setMonthly("Yes").setColored("No").setPages(10).setSubscribeIndex("1-4516-705");
        expectedSet.add(newspaperBuilder.build());

        Booklet.Builder bookletBuilder = new Booklet.Builder();
        bookletBuilder.setId("p-03").setWebsite("http://www.safelife.org/").setTitle("Safe Life").setMonthly("No")
                .setSubscribeDate(LocalDate.parse("2021-03-02")).setColored("Yes").setPages(5).setPageType("Glossy");
        expectedSet.add(bookletBuilder.build());
    }

    @AfterClass
    public void afterClass() {
        expectedSet = null;
    }

    @DataProvider (name = "parserFactoryClassDataTest")
    public Object[][] parserFactoryClassDataTest() {
        return new Object[][] {
                {"sax", PublicationSAXParser.class},
                {"dom", PublicationDOMParser.class},
                {"stax", PublicationStAXParser.class},
        };
    }

    @DataProvider (name = "parserDataTest")
    public Object[][] parserDataTest() {
        return new Object[][] {
                {"sax", expectedSet},
                {"dom", expectedSet},
                {"stax", expectedSet}
        };
    }

    @Test (dataProvider = "parserDataTest")
    public void parserTest(String typeOfParser, Set<Publication> expected) throws PublicationException {
        PublicationParser parser = PublicationParserFactory.createPublicationParser(typeOfParser);
        parser.buildPublicationSet(PAPERS_XML_FILE);
        Set<Publication> actual = parser.getPublicationList();

        Assert.assertEquals(actual, expected);
    }

    @Test (dataProvider = "parserFactoryClassDataTest")
    public void parserFactoryClassTest(String typeOfParser, Class<PublicationParser> expected) throws PublicationException {
        PublicationParser actual = PublicationParserFactory.createPublicationParser(typeOfParser);

        Assert.assertEquals(actual.getClass(), expected);
    }

    @Test (expectedExceptions = PublicationException.class)
    public void parserFactoryFailedTest() throws PublicationException {
        PublicationParserFactory.createPublicationParser("missing");
    }


}
