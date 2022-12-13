import React from "react";
import Header from "./Header";
import Footer from "./Footer";
import Home from "./Home";
import Signup from "./member/Signup";
import Login from "./member/Login";
import Regist from "./admin/Regist";
import {BrowserRouter, Routes , Route ,Link} from 'react-router-dom';

export default function Index (props){
    return(

        <div className="webbox">
            <BrowserRouter>
                <Header/>
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/member/signup" element={<Signup/>}/>
                    <Route path="/member/login" element={<Login/>}/>
                    <Route path="/admin/register" element={<Regist/>}/>
                </Routes>
            
                <Footer/>
            
            
            </BrowserRouter>


        </div>


    );


}