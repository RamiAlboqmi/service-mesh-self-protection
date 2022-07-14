package com;

import com.Planner.MAPE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class main {
// Add a processor values then pass it.
@Autowired
private StoreservicerequestRepository userR;


// This return the user_ip address after provide the request_id. If found, return it.
public String GetIP_fun (String requestid ) {

    ResponseEntity r = new ResponseEntity <List<Storeservicerequest>> (userR.findByRequestid( requestid) , HttpStatus.OK);
    List<Storeservicerequest> userd = (List<Storeservicerequest>) r.getBody();
    String IP = "";
    IP = userd.stream().map(Storeservicerequest::getUserip).collect(Collectors.toList()).get(0);
    Long CountINDB = userR.countByUserip(IP);
    // If user there more than one record of the IP associated with more than one requests, return it
        if (CountINDB > 1){
            IP = userd.stream().map(Storeservicerequest::getUserip).collect(Collectors.toList()).get(0);
            System.out.println("GetIP_fun (): GetIP_fun: Here is the IP:"+IP);
        }
        // If there is one record in the DB that means this is a first request made by the user.
        else if (CountINDB == 1){
            IP = "FirstRequest";
            System.out.println("GetIP_fun (): FirstRequest");
        }
        // Just in case return it as a new.
        else {
            System.out.println("GetIP_fun (): New");
            IP = "New";
        }
        return IP;
    }


    // This return the result of the Adaptation Assessment Framework (AAF) result either V1, V2, V3 or Block.
@RequestMapping("/decideTrafficRoute/{request_id}")
public String decideTrafficRoute (@PathVariable(value = "request_id") String requestid) {

    String numberofrequest = "0";
    String IP = GetIP_fun(requestid);
    String SelectedAdaptation = "";

    // mean new user. No existing in the DB.
    if ( IP == "New" ){
        MAPE m = new MAPE();
        System.out.println("MAPE_response (): New IP and the number of requets is 0 by default " );
        SelectedAdaptation = m.MAPE_response("1", "true");

    }
    // First request user, number of requests is 1
    else if (IP == "FirstRequest") {
        // New user, new Requests

        // Call the MAPE() method in the AAF to get the right assessment.
        MAPE m = new MAPE();
        SelectedAdaptation = m.MAPE_response("1", "true");

    }
    else {
        // Returning user, number of requests is more than 1 and return as it is.
        SimpleDateFormat f= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm z");
        Date d = new Date(System.currentTimeMillis());
        String date = f.format(d) ;

        System.out.println("MAPE_response (): current date:"+ date);

        ResponseEntity rep = new ResponseEntity <List<Storeservicerequest>> (userR.findByUseripAndDate( IP , date ) , HttpStatus.OK);
        List<Storeservicerequest> u = (List<Storeservicerequest>) rep.getBody();
        int numberofrequestInt = u.size();
        numberofrequest = "" + numberofrequestInt;
        System.out.println("MAPE_response ():  Not New IP and the number of requests are: "+ numberofrequest );
        // Call the MAPE() method in the AAF to get the right assessment.
        MAPE m = new MAPE();
        SelectedAdaptation = m.MAPE_response(numberofrequest, "false");
    }
    System.out.println("decideTrafficRoute method(): New Selected Adaptation is:"+SelectedAdaptation);
    return SelectedAdaptation ;
    }


    // This method save the request id and the IP address as well with the request occurred time.
    @RequestMapping("/Save/{request_id}/{user_ip}")
    public String Save (@PathVariable(value = "request_id") String request_id, @PathVariable(value = "user_ip") String user_ip) {
        SimpleDateFormat f= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm z");
        Date d = new Date(System.currentTimeMillis());
        System.out.println("######= current date:"+ f.format(d));
        String date_value = f.format(d);
        Storeservicerequest temp = new Storeservicerequest();
        temp.setRequestid(request_id);
        temp.setUserip(user_ip);
        temp.setDate(date_value);
        userR.save(temp);
        return "DONE";
    }

}
