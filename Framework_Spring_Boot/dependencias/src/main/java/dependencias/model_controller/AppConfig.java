package dependencias.model_controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dependencias.model_controller.model.service.ClaseServicio3;
import dependencias.model_controller.model.service.IClaseServicio;

@Configuration
public class AppConfig {

  //Creamos una instacia de la clase servicio3, y la registramos como componente de spring con la notacion BEAN
  @Bean("miServicio-C")
  public IClaseServicio ic(){
    return new ClaseServicio3();
  }
    
}