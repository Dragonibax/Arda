import React from 'react'
import { Container } from 'react-bootstrap'

// Import Swiper React components
import { Swiper, SwiperSlide} from "swiper/react";
import { Navigation } from "swiper";  

// Import Swiper styles
import "swiper/css";
import "swiper/css/navigation";


function Inicio() {

   
    return (  
        <Container fluid className="Container-prueba">
        <p className="Container-prueba">Trabajando...</p>

        <div className="SABswiper">
        <Swiper navigation={true} modules={[Navigation]} className="mySwiper">
        <SwiperSlide>Slide 1</SwiperSlide>
        <SwiperSlide>Slide 2</SwiperSlide>
        <SwiperSlide>Slide 3</SwiperSlide>
        <SwiperSlide>Slide 4</SwiperSlide>
        <SwiperSlide>Slide 5</SwiperSlide>
        <SwiperSlide>Slide 6</SwiperSlide>
        <SwiperSlide>Slide 7</SwiperSlide>
        <SwiperSlide>Slide 8</SwiperSlide>
        <SwiperSlide>Slide 9</SwiperSlide>
      </Swiper>

      </div>
        </Container>

    );
}

export default Inicio;