package com.apache.wicket.examples;

import com.apache.wicket.examples.model.Cart;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * @author Ajithlal
 * @created 16/07/2021-7:01 PM
 * @project ApacheWicket-Chapter01
 */
public class CheesrSession extends WebSession {
    private Cart cart=new Cart();

    public CheesrSession(Request request) {
        super( request );
    }

    public Cart getCart() {
        return cart;
    }
}
