package com.mycompany;

import com.mygym.service.TrainingService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/index")
public class IndexController {

    
    TrainingService newSession;

    @GET
    @Path("/msg")
    public String getIndexMessage() {
        try {
            newSession = lookupService("java:app/TrainingService");
        } catch (NamingException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //test DB connection
        return newSession.selectAll();
    }

    private TrainingService lookupService(String serviceName) throws NamingException {
        InitialContext context = new InitialContext();
        try {
            return (TrainingService)
                    context.lookup(serviceName);
        } catch (NamingException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
