import React, { useContext, useEffect, useState  } from 'react';
import { Button, Col, Container, FloatingLabel, Form, Row, FormLabel } from 'react-bootstrap';
import UserContext from '../Context/UserContext';
import ApiPublic from '../Servicios/apiPublica';
import Swal from 'sweetalert2';
import ApiPrivate from '../Servicios/apiPrivada';


function Masterrario() {
    

    const [ubicacion, setubicacion] = useState("");
    const [altura, setaltura] = useState("");
    const [iluminacion_tipo, setiluminacion] = useState("");
    const [mac, setmac] = useState("");
    const sabtoken="Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTYWJpbm8iLCJVc2VyIjp7ImlkIjoiNjM1ODY0OTljNWZmNGM2Njg2ODk5NjYxIiwiY29ycmVvIjoic2FiaW5vLnNubUBnbWFpbC5jb20iLCJjb250cmFzZcOxYSI6IiIsIm5vbWJyZSI6IlNhYmlubyJ9LCJpYXQiOjE2NjY3Mzg0MDEsIlRlcnJhcmlvIjp7ImlkIjoiNjM1ODY0Y2NjNWZmNGM2Njg2ODk5NjYyIiwidWJpY2FjaW9uIjoiaW50ZXJpb3IiLCJhbHR1cmEiOiIxMjYgY20iLCJpbHVtaW5hY2lvbl90aXBvIjoiYXJ0aWZpY2lhbCIsInVzdWFyaW9zX2lkIjoiNjM0YzlhYWVjMjIwMjM0OWUzNTZhMjZhIiwibWFjIjoiMTkyLjE2OC4xMjguMTU1In0sImV4cCI6MTY2NjgyNDgwMX0.qRkmgi_72UbPbE5H66-uI0rshUVWihyfsSKnI_PzAxo";
    const [Terrarios, setTerrarios] = useState([]);


const SendData = ()=> {
        const data = {
            ubicacion,
            altura,
            iluminacion_tipo,
            mac
        }

        ApiPrivate.RegistrarTerrario(data,sabtoken)
        .then(response => {
            if (response.data.body) {
                setTerrarios(response.data.body)
            }
        })

        .catch(error => {
            console.log(error.response)
        })
}

//const RegistrarTerrario = (payload,header) => base.post("terrarios",payload,{headers:{'Authorization':header}}) 
//const VerTerrarios = (token) => base.get("terrarios",{headers:{'Authorization': token}})



    return (
        <Container className='Sabterrarios'>
            <Row className="mb-3">
                <Col>   
                <FormLabel className='Sabtitleterrario'>
                       Añadir terrario
                       <br/>
                       introduzca los datos del nuevo terrario
                        </FormLabel>
                </Col>
            </Row>
            <Row className="mb-3">
                <Col>
                    <FloatingLabel label="Ubicacion" className="mb-3">
                        <Form.Control type="Text" placeholder="Ubicacion" value={ubicacion} onChange={(e) =>setubicacion(e.target.value)}/>
                    </FloatingLabel>

                    <FloatingLabel label="Altura" className="mb-3">
                        <Form.Control type="text" placeholder="Altura" value={altura} onChange={(e) =>setaltura(e.target.value)}/>
                    </FloatingLabel>

                    <FloatingLabel label="Tipo de iluminacion" className="mb-3">
                        <Form.Control type="text" placeholder="iluminacion_tipo" value={iluminacion_tipo} onChange={(e) =>setiluminacion(e.target.value)}/>
                    </FloatingLabel>

                    <FloatingLabel label="Direccion MAC del terrario" className="mb-3">
                        <Form.Control type="Text" placeholder="MAC" value={mac} onChange={(e) =>setmac(e.target.value)}/>
                    </FloatingLabel>

                </Col>
            </Row>
            <Row className="mb-3">
                <Col lg={4}></Col>
                <Col>
                <Container fluid>

                    <Button variant="ArdaGreen" size="lg" type='button' onClick={SendData}>Añadir terrario</Button>
                </Container>
                </Col>
                <Col lg={4}></Col>
            </Row>
        </Container>
    );
}

export default Masterrario;