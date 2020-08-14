package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

// Handler value: example.Handler
public class Handler implements RequestHandler<Map, String>{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public String handleRequest(Map event, Context context)
    {
        LambdaLogger logger = context.getLogger();
        // log execution details
        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
        logger.log("CONTEXT: " + gson.toJson(context));
        // process event
        logger.log("EVENT: " + gson.toJson(event));
        logger.log("EVENT TYPE: " + event.getClass().toString());
        Map params = (Map) event.getOrDefault("params"
                , new HashMap<String, Map>());
        Map queryString = (Map) params.getOrDefault("querystring"
                , new HashMap<String, Map>());

        String a = new String("Hello " + queryString.get("name"));
        ArrayList<Integer> a = new ArrayList<Integer>();
        while(true){
            a.add(1);
        }
        return response;
    }
}
