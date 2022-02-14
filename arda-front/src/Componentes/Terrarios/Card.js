import React from 'react';
import { Button, ButtonGroup, Card, Dropdown } from 'react-bootstrap';
import {Link} from 'react-router-dom';

function Terrario({terrario}) {
    const colorAcciones = "ArdaGreen";
    return ( 
        <Card>
            <Card.Header as="h5" className="title-Arda">
                {terrario.ubicacion}
            </Card.Header>
            <Card.Body>
                <Card.Title>Direccion Mac:</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">{terrario.mac}</Card.Subtitle>
                <Card.Title>Datos:</Card.Title>
                <Card.Subtitle>Tipo de iluminacion:</Card.Subtitle>
                <Card.Text>{terrario.iluminacion_tipo}</Card.Text>
                <Card.Subtitle>Ubicacion Actual</Card.Subtitle>
                <Card.Text>{terrario.ubicacion}</Card.Text>
                <Dropdown as={ButtonGroup}>
                    <Button variant={colorAcciones}>Monitorear</Button>
                    <Dropdown.Toggle split variant={colorAcciones}/>
                    <Dropdown.Menu>
                        <Dropdown.Item>Editar Datos</Dropdown.Item>
                        <Dropdown.Item>Eliminar Terrario</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
            </Card.Body>
        </Card>
     );
}

export default Terrario;