import React, { useContext } from 'react';
import { Routes, Route, Navigate } from "react-router-dom";
import Inicio from '../Paginas/Inicio';
import Login from '../Paginas/Login';
import Signin from '../Paginas/Signin';
import UserContext from '../Context/UserContext';
import Terrarios from '../Paginas/Terrarios';
import MonitorPrincipal from '../Paginas/Monitor';
import Masterrario from '../Paginas/Masterrario';
import Contacto from '../Paginas/Contacto';
import Adquirir from '../Paginas/Adquirir';

function Router(props) {
    const {Loged} = useContext(UserContext);
    return (
        <Routes>
            <Route path="/" >
                <Route index element={<Inicio />}/>
                <Route path="login" element={!Loged?<Login />:<Navigate to="/monitor-principal"/>} />
                <Route path="signin" element={!Loged?<Signin />:<Navigate to="/monitor-principal"/>} />
                <Route path="monitor-principal" element={Loged?<MonitorPrincipal />:<Navigate to="/login"/>}/>
                <Route path="terrarios" element={Loged?<Terrarios/>:<Navigate to="/login"/>}/>
                <Route path="masterrario" element={Loged?<Masterrario/>:<Navigate to="/login"/>}/>
                <Route path="contacto" element={<Contacto/>} />
                <Route path="adquirir" element={<Adquirir/>} />
            </Route>
        </Routes>
    );
}
export default Router;