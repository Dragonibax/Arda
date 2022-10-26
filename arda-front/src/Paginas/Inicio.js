import React from 'react'
import { Container } from 'react-bootstrap'

// Import Swiper React components
import { Swiper, SwiperSlide} from "swiper/react";
import { Navigation, Autoplay, Pagination, FreeMode} from "swiper";  

// Import Swiper styles
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";


function Inicio() {

   
    return (  
        
        
        <Container fluid className="Container-prueba">
       
        <h1 className="PrincipalTitle"> ARDA PROYECT</h1>
        <div className="SABswiper">
        

               

        <Swiper
        
        loop={true}
          autoplay={{
          delay: 5000,
          disableOnInteraction: false,
        }}
        pagination={{
          clickable: true,
          type: "progressbar",
          dynamicBullets: true,
        }}
        navigation={true}
        modules={[Autoplay, Pagination, Navigation]}
        className="mySwiper"
      >
      
        <SwiperSlide className='SL1'>
          Dieta de la iguana<br></br><br></br>
          Las iguanas deben seguir una dieta rica en verdura, ya que son herbívoras. Sinn embargo, le podemos ofrecer otro tipo de alimentos. 
          La alimentación de la iguana debe estar conformada por un  75% de verduras ricas en calcio y  25% Fruta
        </SwiperSlide>
        
        <SwiperSlide className='SL2'>
        ---- Cosas que le puedes dar seguido de comer en la proporcion 75%-25% ---
        <br></br><br></br>
          Escarola, Flor calabaza, Remolacha, Perejil, Tomate, Calabacín, Pepino, Pimiento, Judías, Hojas de moztaza,Fresas, Plátano, Melón, Mera
        </SwiperSlide>
        
        <SwiperSlide className='SL3'>
        Es importante ser consciente de que, debido a su condición herbívora, el organismo de la iguana no está preparado para digerir carne o alimentos de origen animal. Es por eso que se debe evitar ofrecerle comida con proteína animal y grasa.
        </SwiperSlide>
                
        <SwiperSlide className='SL4'>
        <ul>
        <li>Lechuga iceberg (lechuga común): tiene un valor nutricional muy bajo y además puede provocar falta de apetito. Se puede incluir en la dieta de forma ocasional y en baja proporción, mezclada con otras verduras.</li>
        </ul>
        
        </SwiperSlide>

        <SwiperSlide className='SL5'><ul>
        <li>Lechuga iceberg (lechuga común): tiene un valor nutricional muy bajo y además puede provocar falta de apetito. Se puede incluir en la dieta de forma ocasional y en baja proporción, mezclada con otras verduras.</li>
        </ul></SwiperSlide>
        
        <SwiperSlide className='SL6'>
          Es muy importante que la dieta de la iguana incluya altos porcentajes de vitamina D, calcio y fósforo, para impedir que el reptil contraiga enfermedades como la enfermedad metabólica del hueso o MBD, una de las más frecuentes entre las iguanas verdes en cautividad.
        </SwiperSlide>
        
      <SwiperSlide className='SL7'> 
        Es muy importante que la dieta de la iguana incluya altos porcentajes de vitamina D, calcio y fósforo, para impedir que el reptil contraiga enfermedades como la enfermedad metabólica del hueso o MBD, una de las más frecuentes entre las iguanas verdes en cautividad.
      </SwiperSlide>


      </Swiper>

      </div>

        <div className='objetivos'>
        <br></br><br></br><br></br><br></br>    
        <h2>
            OBJETIVO
        </h2>
        <div>ARDA tiene como objetivo brindarle una plataforma sencilla e intuitiva para el monitereo de los sistemas ambientales de su terrario certificado</div>
        <h1>
            ¿Qué necesitas para usar ARDA?
        </h1>
        <ul>
    <li>Crear una cuenta.</li>
    <li>Contar con un celular o computadora con conexión a internet y acceso a un navegador web.</li>
    <li>Contar con un terrario certificado.</li>
    <li>Tener registrado tu correo electrónico válido para recibir notificaciones relacionadas a tu terrario.</li>
        </ul>
        <h1>
            ¿Qué puedes hacer con esta app? 
        </h1>
        <ul>
    Funcionalidades:
    ARDA....
    <li>Muestra de manera practica en cualquier momento los valores ambientales de su terrario a través de la aplicación web.</li>
    <li>Genera graficas en tiempo real de los valores de humedad y temperatura</li>
    <li>Muestra recomendaciones sobre los cuidados basicos de una iguana, asi como informacion general sobre estas</li>
    <li>Te notificara cada que exista una anomalia dentro de tu terrario</li>           
    RECORDATORIO
    <li>Recuerda que la cobertura del servicio dependerá de tu conexión a internet.</li>
        </ul>  
          
          
        </div> 





        </Container>

    );
}

export default Inicio;