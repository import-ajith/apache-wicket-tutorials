package com.apache.wicket.examples;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * @author Ajithlal
 * @created 16/07/2021-4:50 PM
 * @project ApacheWicket-Chapter01
 */
public class ApplicationIntilializer extends WebApplication {
public ApplicationIntilializer(){

}

    @Override
    public Class<? extends Page> getHomePage() {
        return SampleApplication.class;
    }
}
