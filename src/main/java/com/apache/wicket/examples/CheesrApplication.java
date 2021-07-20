package com.apache.wicket.examples;

import com.apache.wicket.examples.model.Cheese;
import com.apache.wicket.examples.page.Index;
import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ajithlal
 * @created 16/07/2021-6:45 PM
 * @project ApacheWicket-Chapter01
 */
public class CheesrApplication extends WebApplication {

    public CheesrApplication() {

    }

    @Override
    protected void init() {

    }

    public static CheesrApplication get(){
        return (CheesrApplication) Application.get();
    }

    public List<Cheese> getCheeses(){
        return Collections.unmodifiableList( cheeses );
    }

    @Override
    public Session newSession(Request request, Response response) {
        return new CheesrSession(request);
    }

    private List<Cheese> cheeses= Arrays.asList(new Cheese("Gouda","Gouda is yellowish Dutch",1.65),
            new Cheese("Edam","Edam is yellowish Dutch",1.87),
            new Cheese("Maasdam","Maasdam is yellowish Dutch",1.34),
            new Cheese("Brie","Brie is yellowish Dutch",9.0),
            new Cheese("Buxton Blue","Buxton is yellowish Dutch",1));

    @Override
    public Class<? extends Page> getHomePage() {
        return Index.class;
    }
}
