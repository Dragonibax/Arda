import React, { useContext, useEffect, useState } from 'react';
import { Button, ButtonGroup, Card, Dropdown, Row } from 'react-bootstrap';
import UserContext from '../../Context/UserContext';
import ApiPrivate from '../../Servicios/apiPrivada';
import Temperatura from './GraficaTemperatura';
import Humedad from './GraficaHumedad';

function MonitorTerrario({terrario, ubicacion, update}) {
    const {JWT} = useContext(UserContext);
    const [Stats, setStats] = useState([]);

    const dataTemp = [["Point (Sustituir por fecha)","Temperatura"]];
    const dataHume = [["Point (Sustituir por fecha)","Humedad"]];
    for(var i=0; i<Stats.length; i++){
        dataTemp.push([i+1,Number(Stats[i].temperatura)])
        dataHume.push([i+1,Number(Stats[i].humedad)])
    }
    useEffect(() => {
        ApiPrivate.ObtenerEstadisticas(terrario,JWT)
        .then(result => {
            setStats(result.data.body.reverse());
            console.log(result.data.body)
        })
    }, [update]);
    
    useEffect(() => {
        ApiPrivate.ObtenerEstadisticas(terrario,JWT)
        .then(result => {
            setStats(result.data.body);
        })
    }, []);

    return ( 
        <>
        <Card>
            <Card.Header as="h5" className="title-Arda">
                {ubicacion}
            </Card.Header>
            <Card.Body>
                <Row xs={1} md={1} lg={2}>
                    <Temperatura data = {dataTemp}/>
                </Row>
            </Card.Body>
        </Card>

        <Card>
            <Card.Header as="h5" className="title-Arda">
                {ubicacion}
            </Card.Header>
            <Card.Body>
                <Row xs={1} md={1} lg={2}>
                    <Humedad data = {dataHume}/>
                </Row>
            </Card.Body>
        </Card>
        </>
     );
}

export default MonitorTerrario;