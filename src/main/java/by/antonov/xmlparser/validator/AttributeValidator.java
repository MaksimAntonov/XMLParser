package by.antonov.xmlparser.validator;

public class AttributeValidator {
    private static String ID_REGEXP = "p-[0-9]{2,3}";
    private static String WEBSITE_REGEXP = "http(s)?://(www.)?([A-z0-9_-].?)+.([a-z]){2,4}/";

    private AttributeValidator() {}

    public static boolean isID(String stringForValidation) {
        return stringForValidation.matches(ID_REGEXP);
    }

    public static boolean isWebSite(String stringForValidation) {
        return stringForValidation.matches(WEBSITE_REGEXP);
    }
}
