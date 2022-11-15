import axios from 'axios';

const base = axios.create({
    
    baseURL: 'https://ardaapi-arda.azuremicroservices.io/api/public/'
})

const IniciarSesion = (payload) => base.post("iniciarsesion", payload)
const Registrar = (payload) => base.post("registrar", payload)

const ApiPublic = {
    IniciarSesion,
    Registrar
}

export default ApiPublic;