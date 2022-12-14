import React, { useEffect, useState, useContext } from "react";
import { Button, Card } from "react-bootstrap";
import { Link } from "react-router-dom";
import Swal from "sweetalert2";
import UserContext from "../../Context/UserContext";
import ApiPrivate from "../../Servicios/apiPrivada";


function sabespera(){
  window.location.href = "/terrarios";   
}

function Terrario({ terrario }) {
  const colorAcciones = "ArdaGreen";
  const { JWT } = useContext(UserContext);

  const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: "btn btn-success",
      cancelButton: "btn btn-danger",
    },
    buttonsStyling: false,
  });

  //pruebas para que funcione la edicion de datos
  function Eliminatterrario(id) {
    swalWithBootstrapButtons
      .fire({
        title: "¿Esta seguro de que desea eliminarlo?",
        text: "Esta accion no se puede revertir",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: "Si, Eliminalo!",
        cancelButtonText: "No, cancelar!",
        reverseButtons: true,
        preConfirm: () => {
          //console.log(id)
          ApiPrivate.EliminarTerrario(id, JWT).then((response) => {
              console.log(response.data.Mensaje);

              if (response.isConfirmed) {
                
                swalWithBootstrapButtons.fire(
                  "Cancelado",
                  "El terrario no se eliminara",
                  "error"
                  
                )

              } else {

                swalWithBootstrapButtons.fire({
                  title: "Eliminado!",
                  text: response.data.Mensaje,
                  icon: "success",
                  timer: 5000                 
                })
                  setTimeout(sabespera, 3000);                 
                }


          })
        },
      })
     
  }

  //pruebas para que funcione la edicion de datos

  return (
    <Card>
      <Card.Header as="h5" className="title-Arda">
        {terrario.ubicacion}
      </Card.Header>
      <Card.Body>
        <Card.Title>Identificador:</Card.Title>
        <Card.Subtitle className="mb-2 text-muted">
          {terrario.mac}
        </Card.Subtitle>
        <Card.Title>Datos:</Card.Title>
        <Card.Subtitle>Tipo de iluminacion:</Card.Subtitle>
        <Card.Text>{terrario.iluminacion_tipo}</Card.Text>
        <Card.Subtitle>Ubicacion Actual</Card.Subtitle>
        <Card.Text>{terrario.ubicacion}</Card.Text>

        <Button href="/monitor-principal" variant={colorAcciones}>
          Monitorear
        </Button>
        <Button 
          variant={colorAcciones}
          onClick={() => Eliminatterrario(terrario.id) }
          
        >
          Eliminar
        </Button>
      </Card.Body>
    </Card>
  );
}

export default Terrario;

//<Dropdown.Menu>
//<Dropdown.Item  onClick={EditDat}>Editar Datos</Dropdown.Item>
//<Dropdown.Item>Eliminar Terrario</Dropdown.Item>
//</Dropdown.Menu>
