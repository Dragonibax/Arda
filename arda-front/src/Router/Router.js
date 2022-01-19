import React from 'react';
import { Routes, Route } from "react-router-dom";
import Inicio from '../Paginas/Inicio';

function Router(props) {
    return (
        <Routes>
            <Route path="/" element={<Inicio />}>
                <Route path="login" />
            </Route>
        </Routes>
    );
}
export default Router;