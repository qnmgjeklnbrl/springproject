import React from "react";
import { useState } from "react";
import {BrowserRouter, Routes , Route ,Link, Router} from 'react-router-dom';
export default function Sidemenu(props){
    
    const [isToggleOn1,setIsToggleOn1] = useState(false)
     const [isToggleOn2,setIsToggleOn2] = useState(false)
     
    
    




    function handleClick1(){
        setIsToggleOn1((isToggleOn1)=>!isToggleOn1)
    }
    function handleClick2(){
        setIsToggleOn2((isToggleOn2)=>!isToggleOn2)
    }
    return(
           

        <div>
            <div className="menus">
                <button onClick={handleClick1}>극장 & 상영관 관리</button>
                    {
                        isToggleOn1 && 
                        <>
                            <ul>
                                <li> <Link to="/admin/register/tregist">극장 등록</Link></li>
                                <li><Link to="/member/login">상영관 등록</Link></li>
                            </ul>
                        </>
                    }
                 <button onClick={handleClick2}>영화 관리</button>
                 {
                        isToggleOn2 && 
                        <>
                            <ul>
                            <li><Link to="/member/login"> 영화 등록  </Link></li>
                            <li><Link to="/member/login">상영기간&시간 등록</Link></li>
                            </ul>
                        </>
                    }
            </div>
        </div>    
    );


}
