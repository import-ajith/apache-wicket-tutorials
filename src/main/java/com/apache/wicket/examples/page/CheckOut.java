package com.apache.wicket.examples.page;

import com.apache.wicket.examples.model.Address;
import com.apache.wicket.examples.model.Cart;
import com.apache.wicket.examples.reusable.PercentageTextField;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.application.HeaderContributorListenerCollection;
import org.apache.wicket.datetime.PatternDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.Body;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.time.Duration;
import org.apache.wicket.validation.validator.StringValidator;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @author Ajithlal
 * @created 16/07/2021-9:23 PM
 * @project ApacheWicket-Chapter01
 */
public class CheckOut extends CheesrPage{

    private Date date = new Date();
    public CheckOut() {
        add(new FeedbackPanel( "feedback" ) );
        Form form=new Form( "form" );


        add(form);
        Address address=getCart().getBillingAddress();
        form.add( new TextField( "name",new PropertyModel( address,"name" ) ) .setRequired( true ));
        form.add( new TextField( "street",new PropertyModel( address,"street" ) ).add( StringValidator.lengthBetween(5, 32) ) );
        form.add( new PercentageTextField( "zipcode",new PropertyModel( address,"zipcode" ) ) .setRequired( true ));
        form.add( new TextField( "city",new PropertyModel( address,"city" ) ) );

        List<String> categories= Arrays.asList("Fresh","Whey","Goat","Hard","Blue Vein");
        form.add( new ListChoice( "category",new PropertyModel( address,"category" ) ,categories) );
        address.setCategory( "Blue Vein" );

        //Date Field

        DateTextField txtInvoiceDate=new DateTextField("pickDate",new PropertyModel<Date>(address, "pickDate"),new PatternDateConverter("dd/MM/yyyy", true));
        DatePicker picker = new DatePicker(){
            @Override
            protected boolean enableMonthYearSelection() {
                return true;
            }
        };
        txtInvoiceDate.add(new DatePicker());
        form.add(txtInvoiceDate);

        form.add( new Link("cancel") {
            @Override
            public void onClick() {
                setResponsePage( Index.class );
            }
        } );

        form.add( new Button("order") {
            @Override
            public void onSubmit() {
                Cart cart=getCart();
                cart.getCheeses().clear();
                setResponsePage( Index.class );
             //   System.out.println("<<<<<<<<<<>>>>>>>>>>>"+model);
              //  setResponsePage(new CheeseDetailsPage(selectedCheese)); non bookmarkable
              //  setResponsePage(CheeseDetailsPage.class,new PageParameters("cheese="+cheese.getName())); bookmarkable
            }
        } );

        WebMarkupContainer wmc = new WebMarkupContainer("parent1");
        wmc.setOutputMarkupId(true);
        ListView lv = new ListView("editors",
                Arrays.asList("Tiffany", "Mary", "Cynthia")) {


            @Override
            protected void populateItem(ListItem item) {
                item.add(new Label("name", item.getModelObject().toString()));

            }
        };

        wmc.add(lv);
        add( wmc );

    }
}
