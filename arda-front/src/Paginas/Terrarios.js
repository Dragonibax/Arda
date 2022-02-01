import React, { useContext, useEffect, useState } from 'react';
import { Button, Col, Container, Row } from 'react-bootstrap';
import Terrario from '../Componentes/Terrarios/Card';
import UserContext from '../Context/UserContext';
import ApiPrivate from '../Servicios/apiPrivada'
import { IoIosAddCircle } from 'react-icons/io';

function Terrarios(props) {
    const { JWT, closeSesion } = useContext(UserContext);
    const [Terrarios, setTerrarios] = useState([]);
    const jwt = JWT;
    useEffect(() => {
        ApiPrivate.VerTerrarios(jwt)
            .then(response => {
                if (response.data.body) {
                    setTerrarios(response.data.body)
                }
            })
            .catch(error => {
                console.log(error.response)
                if (error.response.status === 403) {
                    closeSesion();
                }
            })
    }, []);

    return (
        <Container>
            <Row>
                <Col>
                    <h1>Lista de Terrarios Disponibles</h1>
                </Col>
                <Col md={3} lg={3}>
                    <Button>
                        <IoIosAddCircle />
                        {' '}
                        Agregar
                    </Button>
                </Col>
            </Row>
            <Row xs={1} md={3}>
                {Terrarios.length != 0
                    ? Terrarios.map((terrario, index) => {
                        return (
                            <Col key={index}>
                                <Terrario terrario={terrario} />
                            </Col>
                        )
                    })
                    : "Aun no Tienes Terrarios Registrados"
                }
            </Row>
        </Container>
    );
}

export default Terrarios;