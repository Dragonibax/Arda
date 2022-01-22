import React, { Component } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Menu from './Componentes/Menu';
import Router from './Router/Router';
import UserContext from './Context/UserContext';
import {UserProvider} from './Context/UserContext';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    render() {
        return (
            <div>
                <UserProvider>
                    <Menu />
                    <Router />
                </UserProvider>
            </div>
        );
    }
}

export default App;