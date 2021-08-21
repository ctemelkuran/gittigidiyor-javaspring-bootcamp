package dev.patika.patika0201.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Endpoint(id = "custom")
@Component
public class CustomEndpoint {

    //read, write, delete annoatations

    @ReadOperation
    public Map<String, String> customEndpoint(){
        Map<String, String> myMap = new HashMap<>();
        myMap.put("Hallo bruder", "Danke");
        return myMap;
    }

}
