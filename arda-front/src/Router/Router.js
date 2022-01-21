import React, { useContext } from 'react';
import { Routes, Route, Navigate } from "react-router-dom";
import Inicio from '../Paginas/Inicio';
import Login from '../Paginas/Login';
import UserContext from '../Context/UserContext';

function Router(props) {
    const {Loged} = useContext(UserContext);
    return (
        <Routes>
            <Route path="/" >
                <Route index element={<Inicio />}/>
                <Route path="login" element={!Loged?<Login />:<Navigate to="/monitor"/>} />
            </Route>
        </Routes>
    );
}
export default Router;