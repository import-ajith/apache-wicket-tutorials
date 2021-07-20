package com.apache.wicket.examples.page;

import com.apache.wicket.examples.model.Cart;
import com.apache.wicket.examples.model.Cheese;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
import java.text.NumberFormat;


/**
 * @author Ajithlal
 * @created 17/07/2021-3:28 PM
 * @project ApacheWicket-Chapter01
 */
public class ShoppingCartPanel extends Panel {

    private Cart cart;


    public ShoppingCartPanel(String id, Cart cart) {
        super(id);
        this.cart = cart;

        add(new ListView("cart", new PropertyModel(this, "cart.cheeses")) {
            @Override
            protected void populateItem(ListItem item) {
                Cheese cheese = (Cheese) item.getModelObject();
                item.add(new Label("name", cheese.getName()));
                item.add(new Label("price", "$" + cheese.getPrice()));

                item.add(removeLink("remove", item));
            }
        });
        add(new Label("total", new Model() {
            @Override
            public Serializable getObject() {
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                return nf.format(getCart().getTotal());
            }
        }));
    }

    private Cart getCart() {
        return cart;
    }
}
