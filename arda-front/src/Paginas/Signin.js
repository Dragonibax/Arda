import React, { useContext, useState } from 'react';
import { Button, Col, Container, FloatingLabel, Form, Row, FormLabel } from 'react-bootstrap';
import UserContext from '../Context/UserContext';
import ApiPublic from '../Servicios/apiPublica';
import Swal from 'sweetalert2';

function Signin(props) {
    const [correo, setCorreo] = useState("");
    const [contraseña, setContraseña] = useState("");
    const [usuario, setUsuario] = useState("");
    const {setSesion} = useContext(UserContext);


    const SendData = ()=> {
        const data = {
            correo,
            contraseña
        }
        ApiPublic.Registrar(data)
        .then(response=>{
            setSesion(response.data.body)
            Swal.fire({
                icon: 'success',
                title: 'Registrado con exito',
                text: '---',               
              })
        })
        .catch(error=>{
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
        <Container className='Sablogins'>
            
            <Row className="mb-3">
                <Col>   
                <FormLabel className='SabtitleLogins'>
                       Crear una cuenta
                        </FormLabel>
                </Col>
            </Row>
            
            <Row className="mb-3">
                <Col>
                    <FloatingLabel label="Usuario" className="mb-3">
                        <Form.Control type="user" placeholder="Nombre de usuario" value={usuario} onChange={(e) =>setUsuario(e.target.value)}/>
                    </FloatingLabel>

                    <FloatingLabel label="Correo Electronico"className="mb-3">
                        <Form.Control type="email" placeholder="Usuario@ejemplo.com" value={correo} onChange={(e) =>setCorreo(e.target.value)}/>
                    </FloatingLabel>

                    <FloatingLabel label="Contraseña">
                        <Form.Control type="password" placeholder="Contraseña" value={contraseña} onChange={(e) =>setContraseña(e.target.value)}/>
                    </FloatingLabel>
                </Col>
            </Row>
            <Row>
                <Col lg={4}></Col>
                <Col>
                <Container fluid>

                    <Button variant="ArdaGreen" size="lg" type='button' onClick={SendData}>Crear Cuenta</Button>
                </Container>
                </Col>
                <Col lg={4}></Col>
            </Row>
            
        </Container>
    );
}

export default Signin;