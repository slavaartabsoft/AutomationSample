package utils;

import accounts.Account;
import accounts.AccountType;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigReader {

    private static final String configPath = "config.json";

    public static String getConfigData(String param) {
        try {
            String configJson = new String(Files.readAllBytes(Paths.get(configPath)), StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(configJson);
            return jsonObject.getString(param);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUrl() {
        return getConfigData("url");
    }

    public static Account getAccount(AccountType accountType) {
        try {
            String configJson = new String(Files.readAllBytes(Paths.get(configPath)), StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(configJson);
            Account account = new Account(
                    jsonObject.getJSONObject("credentials").getJSONObject(accountType.getUserType()).getString("login"),
                    jsonObject.getJSONObject("credentials").getJSONObject(accountType.getUserType()).getString("password"),
                    accountType);
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
