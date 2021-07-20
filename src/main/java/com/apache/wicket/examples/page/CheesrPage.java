package com.apache.wicket.examples.page;

import com.apache.wicket.examples.CheesrApplication;
import com.apache.wicket.examples.CheesrSession;
import com.apache.wicket.examples.model.Cart;
import com.apache.wicket.examples.model.Cheese;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.CompoundPropertyModel;

import java.util.List;

/**
 * @author Ajithlal
 * @created 16/07/2021-7:08 PM
 * @project ApacheWicket-Chapter01
 */
public abstract class CheesrPage extends WebPage {



    public CheesrSession getCheerSession(){
        return (CheesrSession) getSession();
    }

    public Cart getCart(){
        return getCheerSession().getCart();
    }

    public List<Cheese> getCheeses(){
        return CheesrApplication.get().getCheeses();
    }
}
