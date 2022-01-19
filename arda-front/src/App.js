import React, { Component } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import Menu from './Componentes/Menu';
import Router from './Router/Router';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    render() {
        return (
            <div>
                <Menu/>
                <Router />
            </div>
        );
    }
}

export default App;