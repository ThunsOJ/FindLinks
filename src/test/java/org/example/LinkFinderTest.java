package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkFinderTest {

    LinkFinder lf = new LinkFinder();

    @Test
    void isValidUrl() {
        String validUrl = "https://www.selenium.dev/";
        String invalidUrl = "htgps://ww.asdfasfasf";

        assertTrue(lf.isValidUrl(validUrl));
        assertFalse(lf.isValidUrl(invalidUrl));
    }

    @Test
    void normalizeUrl() {
        String notNormalizedUrl = "selenium.dev/";
        String normalizedUrl = "https://www.selenium.dev/";
        String otherUrl = "https://selenium.dev/";

        assertEquals(lf.normalizeUrl(notNormalizedUrl), normalizedUrl);
        assertEquals(lf.normalizeUrl(normalizedUrl), normalizedUrl);
        assertNotEquals(lf.normalizeUrl(otherUrl), normalizedUrl);
    }

    @Test
    void printLinks() {
        //I'm too lazy to test void methods right now.
    }
}