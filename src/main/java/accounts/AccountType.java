package accounts;

public enum AccountType {
    STANDARD_USER("standard_user"),
    LOCKED_OUT_USER("locked_out_user"),
    PROBLEM_USER("problem_user"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user");

    private final String userType;

    AccountType(String type) {
        this.userType = type;
    }

    public String getUserType() {
        return userType;
    }
}
