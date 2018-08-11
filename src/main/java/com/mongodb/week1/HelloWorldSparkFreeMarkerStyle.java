package com.mongodb.week1;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;

public class HelloWorldSparkFreeMarkerStyle {

    public static void main(String[] args) {

        final Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);
        configuration.setClassForTemplateLoading(HelloWorldSparkFreeMarkerStyle.class, "/");

        Spark.get("/", new Route() {
            @Override
            public Object handle(final Request request,
                                 final Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("hello.ftl");
                    Map<String, Object> helloMap = new HashMap<>();
                    helloMap.put("name", "Freemarker");

                    helloTemplate.process(helloMap, writer);

                    System.out.println(writer);
                } catch (IOException | TemplateException e) {
                    halt(500);
                    e.printStackTrace();
                }
                return writer;
            }
        });
    }
}
