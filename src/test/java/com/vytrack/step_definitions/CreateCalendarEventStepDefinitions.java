package com.vytrack.step_definitions;

import com.vytrack.pages.activities.CalendarEventsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class CreateCalendarEventStepDefinitions {
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Then("user click on create calendar event button")
    public void user_click_on_create_calendar_event_button() {
        System.out.println("User clicks on create calendar event button");
        calendarEventsPage.clickToCreateCalendarEvent();
    }

    @Then("user enters {string} as title")
    public void user_enters_as_title(String title) {
        System.out.printf("User enter %s as a title",title);
        calendarEventsPage.enterTitle(title);
    }

    @Then("user enters {string} as description")
    public void user_enters_as_description(String description) {
        System.out.println("User enters description: "+ description);
       calendarEventsPage.enterDescription(description);
    }

    @Then("user clicks on save and close button")
    public void user_clicks_on_save_and_close_button() {
        System.out.println("User clicks on save and close button");
        calendarEventsPage.clickSaveAndClose();
    }

    @Then("user verify that description of new calendar event is {string}")
    public void user_verify_that_description_of_new_calendar_event_is(String string) {
        Assert.assertEquals(string,calendarEventsPage.getGeneralInfoDescription());
    }

    @Then("user verifies that title of new calendar event is {string}")
    public void user_verifies_that_title_of_new_calendar_event_is(String string) {
        Assert.assertEquals(string,calendarEventsPage.getGeneralInfoTitle());
    }


    @Then("user enters new calendar event information:")
    public void user_enters_new_calendar_event_information(Map<String,String> dataTable) {
        calendarEventsPage.enterDescription(dataTable.get("description"));
        calendarEventsPage.enterTitle(dataTable.get("title"));
    }

    @Then("user verifies new calendar event was created successfully")
    public void user_verifies_new_calendar_event_was_created_successfully(Map<String,String> dataTable) {
        Assert.assertEquals(dataTable.get("description"),calendarEventsPage.getGeneralInfoDescription());
        Assert.assertEquals(dataTable.get("title"),calendarEventsPage.getGeneralInfoTitle());
    }
}
