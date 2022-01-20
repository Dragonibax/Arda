import React from 'react';
import { Routes, Route } from "react-router-dom";
import Inicio from '../Paginas/Inicio';
import Login from '../Paginas/Login';

function Router(props) {
    return (
        <Routes>
            <Route path="/" >
                <Route index element={<Inicio />}/>
                <Route path="login" element={<Login />} />
            </Route>
        </Routes>
    );
}
export default Router;