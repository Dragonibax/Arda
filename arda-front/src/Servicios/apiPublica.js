import axios from 'axios';

const base = axios.create({
    baseURL: 'http://localhost:9898/api/public/'
})

const IniciarSesion = (payload) => base.post("iniciarsesion", payload)
const Registrar = (payload) => base.post("registrar", payload)

const ApiPublic = {
    IniciarSesion,
    Registrar
}

export default ApiPublic;