package org.example;

import java.util.HashMap;

public class Scratch {

    public static void main( String[] args ) {

        String api_key = "7276e037fed5a44a1968672dae7577fd";
        String app_key = "79c2e03d7220f018c2b880657f476a11121295fe";

        HashMap<String,String>  secret = new HashMap<>();

        secret.put("apiKeyAuth",api_key);
        secret.put("appKeyAuth",app_key);
        //defaultClient.setBasePath("https://us5.datadoghq.com/");
        //defaultClient.configureApiKeys(secret);
    }
}
