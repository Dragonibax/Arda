import React from "react";
import { Container } from "react-bootstrap";

function Adquirir() {
  return (
    <Container fluid className="Container-prueba">

        <div className="white-text">
      <h1 className="AC">Adquirir un terrario</h1>

      <br/><br/>
      <h3>Si estas interesado en este proyecto esta informacion es para ti</h3>

      <h5>Los prototipos de terrarios arda contienen un identificador unico necesario para registrarlo en la aplicacion por lo cual es necesario que se comunique con nosotros para dar de alta dicho terrario</h5>
      <br />
      <h2  className="AC">Terrario certificado ARDA</h2>
      <div>Contiene:</div>
      <li>
        Estructura de madera, reforzada con espuma de poliuterano (85x50x1.26)
      </li>
      <li>Paquete de hojas artificiales, no dañinas para la especie</li>
      <li>Cesped artificial (60x40)</li>
      <li>Tronco para escalar, barnizado</li>
      <li>Hamaca</li>
      <li>1 Foco de iluminacion diurna</li>
      <li>1 Foco de iluminacion nocturna</li>
      <li>1 Calentador ceramico</li>
      <li>3 Ventiladores</li>
      <li>1 Humidificador ultrasonico</li>
      <li>Sistema de control</li>
      <br/>
      <img className='terra' ></img>
      
      <br/><br/><br/><br/>
      <h2>
        Para poder adquirir su propio terrario certificado, por favor
        contactenos a traves del correo ardapendragon@gmail.com
      </h2>
      
      </div>
    </Container>
  );
}

export default Adquirir;
