package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server> {

    private static final double EPSILON = 0.01d;
    private double expectedLoadPercentage;

    public CurrentLoadPercentageMatcher(double expectedLoadPercentage) {
        this.expectedLoadPercentage = expectedLoadPercentage;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a server with load percentage of ")
                   .appendValue(expectedLoadPercentage);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("a server with load percentage of ")
                   .appendValue(item.currentLoadPecentage);
    }

    @Override
    protected boolean matchesSafely(Server server) {
        return server.currentLoadPecentage == expectedLoadPercentage
               || Math.abs(server.currentLoadPecentage - expectedLoadPercentage) < EPSILON;
    }

    public static Matcher<? super Server> hasLoadPercentageOf(double expectedLoadPercentage) {
        return new CurrentLoadPercentageMatcher(expectedLoadPercentage);
    }
}
