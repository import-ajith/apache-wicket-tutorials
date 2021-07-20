package com.apache.wicket.examples.page;

import com.apache.wicket.examples.model.Cheese;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;

/**
 * @author Ajithlal
 * @created 16/07/2021-7:26 PM
 * @project ApacheWicket-Chapter01
 */
public class Index extends CheesrPage {

    private ShoppingCartPanel shoppingCartPanel;

    public Index() {


       // add(new ShoppingCartPanel( "shoppingcart", getCart()));
        //Panel added
       /* add( new ListView("cart",new PropertyModel(this,"cart.cheeses"  ) ) {
            @Override
            protected void populateItem(ListItem item) {
                Cheese cheese= (Cheese) item.getModelObject();
                item.add( new Label( "name",cheese.getName() ) );
                item.add(new Label("price","$" +cheese.getPrice()) );

                item.add( new Link("remove",item.getModel()) {
                    @Override
                    public void onClick() {
                        Cheese selected= (Cheese) getModelObject();
                        getCart().getCheeses().remove( selected );

                    }
                } );
            }
        } );*/
      /*  add(new Label( "total", "$ "+getCart().getTotal() ));*/ /*static model*/


       /* add(new Label("total", new Model() {
            @Override
            public Serializable getObject() {
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                return nf.format(getCart().getTotal());
            }
        }));
        dynamic model
*/
    /*    add( new ListView("cheeses",getCheeses()) {
            @Override
            protected void populateItem(ListItem item) {
                Cheese cheese= (Cheese) item.getModelObject();
                item.add( new Label( "name",cheese.getName() ) );
                item.add(new Label("description",cheese.getDescription()) );
                item.add(new Label("price","$" +cheese.getPrice()) );

                item.add( new Link("add",item.getModel()) {
                    @Override
                    public void onClick() {
                        Cheese selected= (Cheese) getModelObject();
                        getCart().getCheeses().add( selected );

                    }
                } );
            }
        } );*/

        add( new Link("checkout") {
            @Override
            public void onClick() {
                setResponsePage( new CheckOut() );
            }

            @Override
            public boolean isVisible() {
                return !getCart().getCheeses().isEmpty();
            }

        } );


        PageableListView cheeses=new PageableListView("cheeses",getCheeses(),3) {
            @Override
            protected void populateItem(ListItem item) {
                Cheese cheese= (Cheese) item.getModelObject();
                item.add( new Label( "name",cheese.getName() ) );
                item.add(new Label("description",cheese.getDescription()) );
                item.add(new Label("price","$" +cheese.getPrice()) );

              /*  item.add( new Link("add",item.getModel()) {
                    @Override
                    public void onClick() {
                        Cheese selected= (Cheese) getModelObject();
                        getCart().getCheeses().add( selected );

                    }
                } );
            }*/




                item.add( new AjaxFallbackLink("add",item.getModel()) {
                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        Cheese selected= (Cheese) getModelObject();
                        getCart().getCheeses().add( selected );
                        if (target!=null){
                            target.addComponent( shoppingCartPanel );
                        }
                    }
                } );
            }
        };
        shoppingCartPanel=new ShoppingCartPanel( "shoppingcart",getCart() );
        shoppingCartPanel.setOutputMarkupId( true );
        add( shoppingCartPanel );
        add( cheeses );
        add(new PagingNavigator( "navigator" ,cheeses) );




        final WebMarkupContainer group=new WebMarkupContainer( "group" );
        add(group);
        group.add(new Label("dexter", "Omelette du fromage"));
        group.add(new Label("deedee", "That's all you can say!"));


      /*  add( new Link("groupPage") {
            @Override
            public void onClick() {
                group.setVisible( !group.isVisible() );
            }
        } );*/
        group.setOutputMarkupPlaceholderTag( true );

        add( new AjaxFallbackLink("groupPage") {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                group.setVisible( !group.isVisible() );
                if (ajaxRequestTarget!=null){
                    ajaxRequestTarget.add(  group);
                }
            }
       } );




    }
}
