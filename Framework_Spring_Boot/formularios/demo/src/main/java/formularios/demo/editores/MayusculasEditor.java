package formularios.demo.editores;

import java.beans.PropertyEditorSupport;

public class MayusculasEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      
        setValue(text.toUpperCase());
    }

    
    
}