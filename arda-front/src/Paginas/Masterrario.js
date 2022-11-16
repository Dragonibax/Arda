import React, { useContext, useEffect, useState  } from 'react';
import { Button, Col, Container, FloatingLabel, Form, Row, FormLabel } from 'react-bootstrap';
import UserContext from '../Context/UserContext';
import ApiPrivate from '../Servicios/apiPrivada';
import Swal from 'sweetalert2';


function Masterrario() {
    

    const [ubicacion, setubicacion] = useState("");
    const [altura, setaltura] = useState("");
    const [iluminacion_tipo, setiluminacion] = useState("");
    const [mac, setmac] = useState("");
    const [Terrarios, setTerrarios] = useState([]);
    const { JWT } = useContext(UserContext);

const SendData = ()=> {
        const data = {
            ubicacion,
            altura,
            iluminacion_tipo,
            mac
        }

        ApiPrivate.RegistrarTerrario(data,JWT)
        .then(response => {
            if (response.data.body) {
                setTerrarios(response.data.body)
                Swal.fire({
                    icon: 'success',
                    title: 'Registrado con exito',
                    text: '---',  
                    confirmButtonText: '<a href="/terrarios">ok</a>'             
                  })
            }
        })

        .catch(error => {
            console.log(error.response)
            Swal.fire({
                icon: 'error',
                //title: JSON.stringify(error.response.data),
                title: error.response.data.Error,
                text: '---',                           
              })
        })
}



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

                    <Button variant="ArdaGreen" size="lg" type='button'  onClick={SendData} >Añadir terrario </Button>
                </Container>
                </Col>
                <Col lg={4}></Col>
            </Row>
        </Container>
    );
}

export default Masterrario;