package validator;

import form.ProductForm;
import java.util.ArrayList;
import java.util.List;

public class ProductValidator
{
    public List<String> validate( ProductForm productForm )
    {
        List<String> errors = new ArrayList<>();

        String name = productForm.getName();
        if ( isEmpty( name ) ) {
            errors.add( "El producto no tiene nombre" );
        }
        String price = productForm.getPrice();
        if ( isEmpty( price ) ) {
            errors.add( "El producto debe tener un precio" );
        }
        else {
            try {
                Float.parseFloat( price );
            }
            catch( NumberFormatException e ) {
                errors.add( "Precio inválido" );
            }
        }
        return errors;
    }

    private boolean isEmpty( String paramName )
    {
        return paramName == null || paramName.trim().isEmpty();
    }
}
