import {createContext, useState} from 'react';


const UserContext = createContext();

const UserProvider = ({children})=>{
    const [JWT, setJWT] = useState(null);
    const [Loged, setLoged] = useState(false);

    const data = {JWT, Loged, setLoged}
    return (<UserContext.Provider value={data}>{children}</UserContext.Provider>);
}
export {UserProvider};
export default UserContext;