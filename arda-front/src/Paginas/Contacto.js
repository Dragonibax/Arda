import React from "react";
import { Container } from "react-bootstrap";

function Contacto() {
  return (
    <Container fluid className="Container-prueba">
      
      
      <div className="white-text">
      
      <h1  className="AC">¿Por que ARDA?</h1>
      <div>
        El nombre de ARDA es en honor a la iguana Arda Pentragon Martinez con la
        que este proyecto empezo a desarrollarse buscando mejorar su cuidado
        mientras se disminuyera la supervicion y trabajo humano requerido para
        mantener el ambiente en su terrario.
      </div>

      <img className='logo' ></img>


      <h1  className="AC">Contactenos</h1>
      <h2>Gracias por ponerte en contacto con nosotros</h2>
      <div>
        Estamos a tu disposicion para ayudarte. Puedes dirigirte a nosotros a
        traves de:
      </div>
      <li>Mantenimiento o falla</li>
      <div>
        Puedes comunirte con nosotros a traves del siguiente numero +52 55 6376
        4735 de Lunes a viernes de 9am a 15pm
      </div>
      <div>
        O bien a traves de cualquiera de nuestros dos correo:
        sabino.snm@gmail.com y katemichelle35@gmail.com
      </div>
      <li>Para información comercial</li>
      <div>Puedes enviarnos un email a ardapendragon@gmail.com</div>
      </div>

    </Container>
  );
}

export default Contacto;
