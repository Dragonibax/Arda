import React, { useState } from 'react';
import { Button, Col, Container, FloatingLabel, Form, Row } from 'react-bootstrap';

function Login(props) {
    const [Correo, setCorreo] = useState("");
    const [Contraseña, setContraseña] = useState("");
    return (
        <Container>
            <Row>
                <Col>
                    <FloatingLabel
                        label="Correo Electronico"
                        className="mb-3"
                    >
                        <Form.Control type="email" placeholder="Usuario@ejemplo.com" value={Correo} onChange={(e) =>setCorreo(e.target.value)}/>
                    </FloatingLabel>
                    <FloatingLabel label="Contraseña">
                        <Form.Control type="password" placeholder="Contraseña" value={Contraseña} onChange={(e) =>setContraseña(e.target.value)}/>
                    </FloatingLabel>
                </Col>
            </Row>
            <Row>
                <Col lg={4}></Col>
                <Col>
                <Container fluid>

                    <Button variant="ArdaGreen" size="lg">Iniciar Sesion</Button>
                </Container>
                </Col>
                <Col lg={4}></Col>
            </Row>
        </Container>
    );
}

export default Login;