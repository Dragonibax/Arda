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
          Dieta de la iguana<br></br>
          Las iguanas deben seguir una dieta rica en verdura, ya que son herbívoras. Sinn embargo, le podemos ofrecer otro tipo de alimentos. 
          La alimentación de la iguana debe estar conformada por un  75% de verduras ricas en calcio y  25% Fruta
        </SwiperSlide>
        
        <SwiperSlide className='SL2'>
        ---- Cosas que le puedes dar seguido de comer en la proporcion 75%-25% ---
        <br></br>
          Escarola, Flor calabaza, Remolacha, Perejil, Tomate, Calabacín, Pepino, Pimiento, Judías, Hojas de moztaza,Fresas, Plátano, Melón, Mera
        </SwiperSlide>
        
        <SwiperSlide className='SL3'>
        Es importante ser consciente de que, debido a su condición herbívora, el organismo de la iguana no está preparado para digerir carne o alimentos de origen animal.
        </SwiperSlide>
                
        <SwiperSlide className='SL4'>
        <ul>
        <li>Lechuga iceberg (lechuga común): tiene un valor nutricional muy bajo y además puede provocar falta de apetito. Se puede incluir en la dieta de forma ocasional y en baja proporción, mezclada con otras verduras.</li>
        </ul>
        
        </SwiperSlide>

        <SwiperSlide className='SL5'><ul>
        <li>  Las iguanas necesitan para su correcto crecimiento y optimo desarrollo óseo la adición de calcio en su dieta diaria.</li>
        </ul></SwiperSlide>
        
        <SwiperSlide className='SL6'>
          Es muy importante que la dieta de la iguana incluya altos porcentajes de vitamina D, calcio y fósforo, para impedir que el reptil contraiga enfermedades como la enfermedad metabólica del hueso o MBD, una de las más frecuentes entre las iguanas verdes en cautividad.
        </SwiperSlide>
        
      <SwiperSlide className='SL7'> 
        Recuerda cambiar la fuente de iluminación UVA/UVB cada seis meses o al menos una vez al año.
        </SwiperSlide>


      </Swiper>

        </div>

        <h1 className="PrincipalTitle"> ARDA PROYECT</h1>

        <div className='title-cards'>
            <h2>Sobre ARDA</h2>
        </div>
    <div className='container-card'>
        
    <div className='card'>
        <figure>
            <img className='origen'></img>
        </figure>
        <div className='contenido-card'>
            <h3>Origen</h3>
            <p> Mas alla del gusto en los ultimos años la iguana verde en su etapa de cria
                ha comenzado a volverse un prospecto de mascota ideal para los niños debido a su brillante y muy 
                atractivo color verde y carácter dócil. No obstante solemos olvidar que tener una iguana no es lo
                mismo que tener a un perro, gato o pez. Las iguanas requieren de constantes acondicionamientos 
                en cuanto a la iluminacion, temperatura y humedad en su "habitat" que suele ser el aspecto mas dificil
                de mantener al momento de cuidarla.</p>
        </div>
    </div>
    <div className='card'>
        <figure>
            <img className='obj2'></img>
        </figure>
        <div className="contenido-card">
            <h3 className='Comomolestan'>Objetivo</h3>
            <p>ARDA tiene como objetivo brindarle una plataforma sencilla e intuitiva para el monitereo de los sistemas ambientales de su terrario certificado</p>
        </div>
    </div>
    <div className="card">
        <figure>
            <img className='mision' ></img>
        </figure>
        <div className="contenido-card">
            <h3>Mision</h3>
            <p>Pretendemos ser una aplicación viable y unica para ayudarte a mantener las condiciones 
                de humedad, iluminación y temperatura prestablecidas en nuestro sistemas, segun los estandares 
                recomendados para el cuidado de las iguanas sin la constante necesidad de tu intervención
                para los casos donde no dispongas del tiempo o las condiciones climáticas de tu region sean las adecuadas</p>
        </div>
    </div>
    </div>
    
    <div className="contenido-card">

            <h2>ARDA COMO APLICACION</h2>
                <div className='card c1'>
                    <div className='icon'>
                        <h3>¿Qué necesitas para usar ARDA?</h3>
                    </div>
                    <div class="info__description">
                        <ul>
                            <li>Crear una cuenta.</li>
                            <li>Contar con un celular o computadora con conexión a internet y acceso a un navegador web.</li>
                            <li>Contar con un terrario certificado.</li>
                            <li>Tener registrado tu correo electrónico válido para recibir notificaciones relacionadas a tu terrario.</li>
                        </ul>
                    </div>
                </div>

                </div>       

        </Container>

    );
}

export default Inicio;