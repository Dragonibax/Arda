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
        window.localStorage.setItem("jwt",jwt);
    };

    const closeSesion = () => {
        setJWT(null);
        setLoged(false);
        window.localStorage.removeItem("jwt");
    }

    const UpdateJWT = (jwt)=> {
        window.localStorage.clear();
        window.localStorage.setItem("jwt",jwt);
    }

    const data = { JWT, Loged, setSesion, closeSesion, UpdateJWT}
    return (<UserContext.Provider value={data}>{children}</UserContext.Provider>);
}
export { UserProvider };
export default UserContext;