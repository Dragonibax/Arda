import React, { Component } from 'react'
import Inicio from './Paginas/Inicio';
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() { 
        return (
            <Inicio/>
         );
    }
}
 
export default App;