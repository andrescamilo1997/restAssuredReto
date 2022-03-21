package co.com.sofka.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import static co.com.sofka.util.LoginKey.*;

public class UseJsonFormatToString {
    private final String changeJson;
    private final String emailOrName;
    private String password;
    private Object ob;
    private JSONObject js;
    private String todoJson;

    public UseJsonFormatToString(String emailOrName, String password, String changeJson) {
        this.emailOrName = emailOrName;
        this.password = password;
        this.changeJson = changeJson;
    }

    public UseJsonFormatToString(String emailOrName,String changeJson) {
        this.emailOrName = emailOrName;
        this.changeJson = changeJson;
    }



    public String bodyNotSucceed() throws IOException, ParseException {
        ob = new JSONParser().parse(new FileReader(changeJson));
        js = (JSONObject) ob;
        todoJson = JSONObject.toJSONString(js);
        return todoJson.replace(USER.getValue(), emailOrName);
    }

    public String bodyPut() throws IOException, ParseException {
        ob = new JSONParser().parse(new FileReader(changeJson));
        js = (JSONObject) ob;
        todoJson = JSONObject.toJSONString(js);
        String a = todoJson.replace(NAME.getValue(), emailOrName);
        return a.replace(JOB.getValue(), password);
    }

    public String body() throws IOException, ParseException {
        ob = new JSONParser().parse(new FileReader(changeJson));
        js = (JSONObject) ob;
        todoJson = JSONObject.toJSONString(js);
        String a = todoJson.replace(USER.getValue(), emailOrName);
        return a.replace(PASSWORD.getValue(), password);
    }
}
