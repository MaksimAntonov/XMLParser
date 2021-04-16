package by.antonov.xmlparser.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AttributeValidatorTest {
    @DataProvider(name = "isIDTestData")
    public Object[][] isIDTestData() {
        return new Object[][]{
                {"p-007", true},
                {"p-17", true},
                {"p-799", true},
                {"p-74", true},
                {"a-187", false},
                {"p78", false},
                {"p-4556", false},
                {"p-457a", false}
        };
    }

    @DataProvider(name = "isWebSiteTestData")
    public Object[][] isWebSiteTestData() {
        return new Object[][]{
                {"http://www.example.com/", true},
                {"https://www.example.com/", true},
                {"https://learn.epam.com/", true},
                {"https://traning.by/", true},
                {"ftp://example.com", false},
                {"example.com", false},
                {"p-4556", false},
                {"p-457a", false}
        };
    }

    @Test (
            description = "Test for isID method in AttributeValidator",
            dataProvider = "isIDTestData"
    )
    public void isIDTest(String stringForTest, boolean expected) {
        boolean actual = AttributeValidator.isID(stringForTest);

        Assert.assertEquals(actual, expected);
    }

    @Test (
            description = "Test for isWebSite method in AttributeValidator",
            dataProvider = "isWebSiteTestData"
    )
    public void isWebSiteTest(String stringForTest, boolean expected) {
        boolean actual = AttributeValidator.isWebSite(stringForTest);

        Assert.assertEquals(actual, expected);
    }
}
