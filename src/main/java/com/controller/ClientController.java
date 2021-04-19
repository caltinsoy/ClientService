package com.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class ClientController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public String data(@ModelAttribute("first") int first,
                       @ModelAttribute("second") int second,
                       Model model) throws IOException {
        String addService = "http://addservice-env.eba-2ukcsay7.us-east-2.elasticbeanstalk.com/" + first + "/" + second; //urls of add and sub services
        String subService = "http://subservice-env.eba-v4guz2jb.us-east-2.elasticbeanstalk.com/" + first + "/" + second;

        try {
            URL url = new URL(addService);
            HttpURLConnection requestAddService = (HttpURLConnection) url.openConnection();
            requestAddService.connect();

            //COnvert to a JSON object to print data
            JsonParser jsonParser = new JsonParser();
            JsonElement addServiceResult = jsonParser.parse(new InputStreamReader((InputStream) requestAddService.getContent()));

            url = new URL(subService);
            HttpURLConnection requestSubService = (HttpURLConnection) url.openConnection();
            requestSubService.connect();

            JsonParser jsonParserSub = new JsonParser();
            JsonElement subServiceResult = jsonParserSub.parse(new InputStreamReader((InputStream) requestSubService.getContent()));

            model.addAttribute("addService", addServiceResult);
            model.addAttribute("subService", subServiceResult);
            model.addAttribute("result", true);

        } catch (Exception e) {
            throw new IOException("Check Service Connections");
        }

        return "index";
    }
}
