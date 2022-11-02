package formularios.demo.editores;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import formularios.demo.services.HabilidadesImplementacion;

@Component
public class HabilidadesPropertiesEditor extends PropertyEditorSupport{
    
    @Autowired
    private HabilidadesImplementacion serviceHabilidades;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {
       
    //PARA LA VALIDACION DEL CAMPO SELECT DEL FORMULARIO, PREGUNTO SI EL VALOR QUE SE ENVIA EN SELECT ES DIFERENTE A NULL (HA SIDO SELECCIONADO)
    //DE LO CONTRARIO, PARA MANEJAR EL ERROR, HAGO QUE SEA DE TIPO NULL EL VALOR Y ASI CON LA ANOTACION @NOTNULL MUESTRO EL MENSAJE DE ERROR
        if(idString != null && idString.length() > 0 ){

            try {
                Integer id = Integer.parseInt(idString);
                this.setValue(serviceHabilidades.mostrar(id));
            } catch (NumberFormatException e) {
                idString = null;
            }
        }else{
            idString = null;
        }      
    }
}