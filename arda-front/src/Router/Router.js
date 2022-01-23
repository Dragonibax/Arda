import React, { useContext } from 'react';
import { Routes, Route, Navigate } from "react-router-dom";
import Inicio from '../Paginas/Inicio';
import Login from '../Paginas/Login';
import UserContext from '../Context/UserContext';
import MonitorPrincipal from '../Paginas/Principal';

function Router(props) {
    const {Loged} = useContext(UserContext);
    return (
        <Routes>
            <Route path="/" >
                <Route index element={<Inicio />}/>
                <Route path="login" element={!Loged?<Login />:<Navigate to="/monitor"/>} />
                <Route path="monitor" element={Loged?<MonitorPrincipal />:<Navigate to="/login"/>}/>
            </Route>
        </Routes>
    );
}
export default Router;