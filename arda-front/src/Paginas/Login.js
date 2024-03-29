import React, { useContext, useState } from 'react';
import { Button, Col, Container, FloatingLabel, Form, Row, FormLabel } from 'react-bootstrap';
import UserContext from '../Context/UserContext';
import ApiPublic from '../Servicios/apiPublica';
import Swal from 'sweetalert2';

function Login(props) {
    const [correo, setCorreo] = useState("");
    const [contraseña, setContraseña] = useState("");
    const {setSesion} = useContext(UserContext);
    

    const SendData = ()=> {
        const data = {
            correo,
            contraseña            
        }
        ApiPublic.IniciarSesion(data)
        .then(response=>{
            setSesion(response.data.body)
            Swal.fire({
                icon: 'success',
                title: 'bienvenido',
                text: '---',               
              })


        })
        .catch(error=>{
            console.log(error.response)   
            Swal.fire({
                icon: 'error',
                title: JSON.stringify(error.response.data),
                text: '---',               
              })



        })
    }
    
   



    return (
        <Container className='Sablogins'>
            <Row className="mb-3">
                <Col>   
                <FormLabel className='SabtitleLogins'>
                       Iniciar Sesion
                        </FormLabel>
                </Col>
            </Row>
            <Row className="mb-3">
                <Col>
                    <FloatingLabel
                        label="Correo Electronico"
                        className="mb-3"
                    >
                        <Form.Control type="email" placeholder="Usuario@ejemplo.com" value={correo} onChange={(e) =>setCorreo(e.target.value)}/>
                    </FloatingLabel>
                    <FloatingLabel label="Contraseña">
                        <Form.Control type="password" placeholder="Contraseña" value={contraseña} onChange={(e) =>setContraseña(e.target.value)}/>
                    </FloatingLabel>
                </Col>
            </Row>
            <Row className="mb-3">
                <Col lg={4}></Col>
                <Col>
                <Container fluid>

                    <Button variant="ArdaGreen" size="lg" type='button' onClick={SendData}>Iniciar Sesion</Button>
                </Container>
                </Col>
                <Col lg={4}></Col>
            </Row>
        </Container>
    );
}

export default Login;