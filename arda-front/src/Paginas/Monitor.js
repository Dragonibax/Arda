import React, { useContext, useEffect, useState } from 'react';
import { Col, Container, Row } from 'react-bootstrap';
import MonitorTerrario from '../Componentes/Monitor/Card';
import UserContext from '../Context/UserContext';
import ApiPrivate from '../Servicios/apiPrivada';

function MonitorPrincipal() {
    const { JWT, closeSesion } = useContext(UserContext);
    const [Terrarios, setTerrarios] = useState([]);
    const jwt = JWT;
    const [RenderFrec, setRenderFrec] = useState(0);

    useEffect(() => {
        const timer = setInterval(() => {
            setRenderFrec(RenderFrec => RenderFrec + 1);
        }, 5000);
        ApiPrivate.VerTerrarios(jwt)
            .then(response => {
                console.log(response)
                if(response.data.body){
                    setTerrarios(response.data.body)
                }
            })
            .catch(error => {
                console.log(error.response)
                if (error.response.status === 403) {
                    closeSesion();
                }
            })
        return () => {
            clearInterval(timer);
        };
    }, []);

    return (
        <Container>
            <Row>
                <Col>
                    <h1>Monitor Principal</h1>
                </Col>
            </Row>
            <Row>
            {Terrarios.map(
                (terrario, index) => {
                    return (
                        <Row key={index}>
                            <Col>
                                <MonitorTerrario  terrario={terrario.id} ubicacion={terrario.ubicacion} update={RenderFrec} />
                            </Col>
                        </Row>
                    )
                }
            )}
        </Row>
       
       
        </Container>
    );
}

export default MonitorPrincipal;