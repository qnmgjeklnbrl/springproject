import React from "react";
import {BrowserRouter, Routes , Route ,Link} from 'react-router-dom';

export default function Header(props){
    <div>
        <h3 className="header_name">헤더</h3>
            <ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="#">회원가입</Link></li>
                <li><Link to="#">로그인</Link></li>
                <li><Link to="#">마이페이지</Link></li>
                <li><Link to="#">고객센터</Link></li>
            </ul>




    </div>



}