package com.apache.wicket.examples;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * @author Ajithlal
 * @created 16/07/2021-4:11 PM
 * @project ApacheWicket-Chapter01
 */
public class SampleApplication extends WebPage {

    public SampleApplication(){
        add( new Label( "message","Hello World !!" ) );
    }

}
