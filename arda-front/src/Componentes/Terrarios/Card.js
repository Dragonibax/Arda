import React, { useEffect, useState, useContext } from 'react';
import { Button, ButtonGroup, Card, Dropdown } from 'react-bootstrap';
import {Link} from 'react-router-dom';
import Swal from 'sweetalert2';

function Terrario({terrario}) {
    const colorAcciones = "ArdaGreen";


    //pruebas para que funcione la edicion de datos
    function EditDat() {
      
        Swal.fire({
            title: 'Añadir terrario',
            inputAttributes: {
              autocapitalize: 'off'
            },
            showCancelButton: true,
            confirmButtonText: 'añadir',
            showLoaderOnConfirm: true,         
          }).then((result) => {
            if (result.isConfirmed) {
              Swal.fire({
                title: "ingrese los datos",
                imageUrl: result.value.avatar_url
              })
            }
          })


    }

    //pruebas para que funcione la edicion de datos

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
                
                    
                    <Button href="/monitor-principal" variant={colorAcciones}>Monitorear</Button>

            </Card.Body>
        </Card>
     );
}

export default Terrario;

//<Dropdown.Menu>
//<Dropdown.Item  onClick={EditDat}>Editar Datos</Dropdown.Item>                        
//<Dropdown.Item>Eliminar Terrario</Dropdown.Item>
//</Dropdown.Menu>