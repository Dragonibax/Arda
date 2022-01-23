import React, { useContext, useEffect, useState } from 'react';
import { Container } from 'react-bootstrap';
import UserContext from '../Context/UserContext';
import ApiPrivate from '../Servicios/apiPrivada'

function MonitorPrincipal(props) {
    const {JWT, closeSesion} = useContext(UserContext);
    const [Terrarios, setTerrarios] = useState([]);
    const jwt = JWT;
    useEffect(() => {
      ApiPrivate.VerTerrarios(jwt)
      .then(response => {
          console.log(response)
          setTerrarios(response.data.body)
      })
      .catch(error=>{
          console.log(error.response)
          if(error.response.status === 403 ){
              closeSesion();
          }
      })
    }, []);
    
    return ( 
        <Container>
            {Terrarios.map(terrario=>{
                return(
                    <a key={terrario.id}>{terrario.id}</a>
                )
            })}
        </Container>
     );
}

export default MonitorPrincipal;