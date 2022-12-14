import axios from 'axios';

const base = axios.create({
    baseURL: 'https://ardaapi-arda.azuremicroservices.io/api/private/'
    
})

const RegistrarTerrario = (payload,header) => base.post("terrarios",payload,{headers:{'Authorization':header}})
const VerTerrarios = (token) => base.get("terrarios",{headers:{'Authorization': token}})
const ObtenerEstadisticas = (id,token)=>base.get("estadisticas/"+id,{headers:{'Authorization': token}})
const EliminarTerrario = (id,token)=>base.delete("terrarios/"+id,{headers:{'Authorization': token}})

const ApiPrivate = {
    RegistrarTerrario,
    VerTerrarios,
    ObtenerEstadisticas,
    EliminarTerrario,
}

export default ApiPrivate;