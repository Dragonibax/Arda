import React, { useContext, useState } from 'react'

function Cursor(props) {
    
    const[cursorX, setCursorX] = useState()
    const[cursorY, setCursorY] = useState()
    
    window.addEventListener('mousemove', (e)=>{
        setCursorX(e.pageX)
        setCursorY(e.pageY)
    })
    
    return (

            
       <div>
        <div className="cursor"
            style={{
                left: cursorX -250 + 'px',
                top: cursorY -250 + 'px'

        }}/>
        </div>

        
    );
}

export default Cursor;