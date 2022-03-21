package co.com.sofka.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import static co.com.sofka.util.LoginKey.*;

public class UseJsonFormatToString {
    private final String changeJson;
    private final String email;
    private String password;
    private Object ob;
    private JSONObject js;
    private String todoJson;

    public UseJsonFormatToString(String email, String password, String changeJson) {
        this.email = email;
        this.password = password;
        this.changeJson = changeJson;
    }

    public UseJsonFormatToString(String email,String changeJson) {
        this.email = email;
        this.changeJson = changeJson;
    }



    public String bodyNotSucced() throws IOException, ParseException {
        ob = new JSONParser().parse(new FileReader(changeJson));
        js = (JSONObject) ob;
        todoJson = JSONObject.toJSONString(js);
        return todoJson.replace(USER.getValue(), email);
    }

    public String bodyPut() throws IOException, ParseException {
        ob = new JSONParser().parse(new FileReader(changeJson));
        js = (JSONObject) ob;
        todoJson = JSONObject.toJSONString(js);
        String a = todoJson.replace(NAME.getValue(), email);
        return a.replace(JOB.getValue(), password);
    }

    public String body() throws IOException, ParseException {
        ob = new JSONParser().parse(new FileReader(changeJson));
        js = (JSONObject) ob;
        todoJson = JSONObject.toJSONString(js);
        String a = todoJson.replace(USER.getValue(), email);
        return a.replace(PASSWORD.getValue(), password);
    }
}
