import { createContext, useEffect, useState } from 'react';


const UserContext = createContext();

const UserProvider = ({ children }) => {
    const [JWT, setJWT] = useState(null);
    const [Loged, setLoged] = useState(false);
    useEffect(() => {
        const jwt = window.localStorage.getItem("jwt");
        console.log(jwt);
        if(jwt){
            setJWT(jwt);
            setLoged(true);
        }
    }, []);

    const setSesion = (jwt)=> {
        setJWT(jwt);
        setLoged(true);
    };

    const data = { JWT, Loged, setSesion}
    return (<UserContext.Provider value={data}>{children}</UserContext.Provider>);
}
export { UserProvider };
export default UserContext;