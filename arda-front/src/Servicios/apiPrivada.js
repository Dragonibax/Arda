import axios from 'axios';

const base = axios.create({
    baseURL: 'http://localhost:9898/api/private/'
})

const RegistrarTerrario = (payload,header) => base.post("terrarios",payload,{headers:{'Authorization':header}})
const VerTerrarios = (token) => base.get("terrarios",{headers:{'Authorization': token}})

const ApiPrivate = {
    RegistrarTerrario,
    VerTerrarios,
}

export default ApiPrivate;