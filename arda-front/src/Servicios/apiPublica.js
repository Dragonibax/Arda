import axios from 'axios';
import { useContext } from 'react';
import UserContext from '../Context/UserContext';

const base = axios.create({
    baseURL: 'https://localhost:9898/api/public/'
})

const {setSesion} = useContext(UserContext);

const IniciarSesion = (payload) => {
    base.post("inicarsesion",payload)
    .then(response => {
        if(response.status==200){
            setSesion(response.data.body);
        }
        return response.data
    })
}

export {IniciarSesion};