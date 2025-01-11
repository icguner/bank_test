package utils.locater;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocaterParser {

    private static Map<String, ElementMap> locatorMap = new HashMap<>();

    static {
        try (InputStream input = LocaterParser.class.getResourceAsStream("/locators.json")) {
            if (input == null) {
                throw new RuntimeException("locators.json bulunamadı!");
            }
            ObjectMapper mapper = new ObjectMapper();
            List<ElementMap> elementList = mapper.readValue(input, new TypeReference<>() {
            });

            for (ElementMap e : elementList) {
                locatorMap.put(e.getElementName(), e);
            }
        } catch (IOException e) {
            throw new RuntimeException("locators.json okunurken hata oluştu ", e);
        }
    }


    public static By getBy(String elementName) {
        ElementMap elementInfo = locatorMap.get(elementName);
        if (elementInfo == null) {
            throw new RuntimeException(elementName + " adında bir element listede yok.");
        }

        String type = elementInfo.getElementType().toLowerCase();
        String value = elementInfo.getElementValue();

        switch (type) {
            case "id":
                return By.id(value);
            case "xpath":
                return By.xpath(value);
            case "css":
                return By.cssSelector(value);
            case "classname":
                return By.className(value);
            case "name":
                return By.name(value);
            case "tagname":
                return By.tagName(value);
            case "linktext":
                return By.linkText(value);
            case "partiallinktext":
                return By.partialLinkText(value);
            default:
                throw new RuntimeException("Böyle bir locater tipi yok: " + type);
        }
    }
}
