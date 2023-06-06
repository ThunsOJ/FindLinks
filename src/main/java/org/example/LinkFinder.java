package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class LinkFinder {

    public void start(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a URL (You can skip the \"https://www.\" part) to check links: ");
        String url = normalizeUrl(scan.nextLine().trim());

        if (isValidUrl(url)) {
            printLinks(url);
        } else {
            System.out.println("Enter a valid URL!");
            start(); //Retries URL input
        }
    }

    public boolean isValidUrl(String url){

        //Not complete but offers some form of simple validation
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    public String normalizeUrl(String url) {
        StringBuilder sb = new StringBuilder(url);
        if (!url.startsWith("https://") && !url.startsWith("http://")) {
            sb.insert(0, "https://www.");
        }
        return sb.toString();
    }

    public void printLinks(String url){
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(url);

            List<WebElement> linkElements = driver.findElements(By.tagName("a"));

            System.out.println("Web Links on " + url + ":");

            linkElements.stream().map(l -> l.getAttribute("href"))
                    .filter(Objects::nonNull)
                    .forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("URL fetching failed with the error: " + e.getMessage());
        }
        driver.quit();
    }

}
