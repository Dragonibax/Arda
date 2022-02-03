import React, { Component } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Menu from './Componentes/Menu';
import Router from './Router/Router';
import {UserProvider} from './Context/UserContext';
import Body from './Componentes/Body';
import Cursor from './Componentes/Cursor';

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
                    <Body />
                    <Cursor/>
                    <Router/>
                    
                </UserProvider>
            </div>
            
        );
    }
}

export default App;