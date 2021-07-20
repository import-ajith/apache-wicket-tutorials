package com.apache.wicket.examples.reusable;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author Ajithlal
 * @created 19/07/2021-5:39 PM
 * @project ApacheWicket-Chapter01
 */
public class PercentageTextField extends TextField {
    public PercentageTextField(String id) {
        super( id,double.class );
    }

    public PercentageTextField(String id, IModel model) {
        super( id, model ,double.class);
    }

    @Override
    public final IConverter getConverter(Class type) {

        return new IConverter() {
            @Override
            public Object convertToObject(String s, Locale locale) {
                try {
                    return getNumberFormat(locale).parseObject( s );
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new ConversionException( e );
                }
            }

            @Override
            public String convertToString(Object o, Locale locale) {
                return getNumberFormat(locale).format( (Double) o);
            }

            private NumberFormat getNumberFormat(Locale locale){
                DecimalFormat fmt=new DecimalFormat("##");
                fmt.setMultiplier( 100 );
                return fmt;
            }
        };


    }
}
