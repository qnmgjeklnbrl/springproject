import React from "react";
import {BrowserRouter, Routes , Route ,Link} from 'react-router-dom';
import Styles from "../css/header.css";
export default function Header(props){
    return(
        <div>
            <div className="header">
                <ul className ="top_menu">
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/member/login">로그인</Link></li>
                    <li><Link to="/member/signup">회원가입</Link></li>
                    <li><Link to="/">마이페이지</Link></li>
                    <li><Link to="/">예매하기</Link></li>
                
                </ul>



            </div>
            
        </div>

    );
    


}