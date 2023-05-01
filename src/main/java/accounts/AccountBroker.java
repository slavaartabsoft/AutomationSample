package accounts;

import utils.ConfigReader;

public class AccountBroker {

    private static Account getAccount(AccountType accountType) {
        return ConfigReader.getAccount(accountType);
    }

    public static Account getStandardUser() {
        return getAccount(AccountType.STANDARD_USER);
    }

    public static Account getLockedOutUser() {
        return getAccount(AccountType.LOCKED_OUT_USER);
    }

    public static Account getProblemUser() {
        return getAccount(AccountType.PROBLEM_USER);
    }

    public static Account getPerformanceGlitchUser() {
        return getAccount(AccountType.PERFORMANCE_GLITCH_USER);
    }

}
