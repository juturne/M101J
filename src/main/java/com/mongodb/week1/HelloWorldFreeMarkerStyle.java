package com.mongodb.week1;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldFreeMarkerStyle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);
        configuration.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");

        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<>();
            helloMap.put("name", "Freemarker");

            helloTemplate.process(helloMap, writer);

            System.out.println(writer);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
