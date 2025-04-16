package com.epam.automation.utils;

import java.util.Arrays;
import java.util.List;

public class DataProviderUtils {

    // UC-1: Login with empty credentials (after typing and clearing)
    public static List<Object[]> emptyCredentialsProvider() {
        return Arrays.asList(new Object[][]{
                {"dummy", "dummy"}  // values that will be cleared before submission
        });
    }

    // UC-2: Username present, password cleared
    public static List<Object[]> usernameOnlyProvider() {
        return Arrays.asList(new Object[][]{
                {"standard_user", "dummy"}  // password will be cleared
        });
    }

    // UC-3: Valid login
    public static List<Object[]> validCredentialsProvider() {
        return Arrays.asList(new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        });
    }
}
