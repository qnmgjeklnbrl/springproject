import React ,{useState}from "react";
import {BrowserRouter, Routes , Route ,Link} from 'react-router-dom';
import Styles from "../css/header.css";
import axios from "axios";

export default function Header(props){
    const[login,setLogin] = useState(null);
    axios
        .get("/member/getloginMno")
        .then((res)=>setLogin(res.data))

    return(
        <div>
            <div className="header">
                <ul className ="top_menu">
                    <li><Link to="/">Home</Link></li>
                    {
                        login==""&&
                       <>
                            <li><Link to="/member/login">로그인</Link></li>
                            <li><Link to="/member/signup">회원가입</Link></li>
                            <li><Link to="/">예매하기</Link></li>
                       </>

                    }
                    {login!=""&&
                       
                        <>
                            
                            <li> { login } 님 환영합니다.</li>
                            <li><Link to="/">로그아웃</Link></li>
                            <li><Link to="/">마이페이지</Link></li>
                            {
                                login=="admin"&&
                                <li><Link to="/">관리자모드</Link></li>
                            }
                           
                        </>
                       
                    
                    }
                    
                </ul>



            </div>
            
        </div>

    );
    


}