import React from "react";
import Header from "./Header";
import Footer from "./Footer";
import Home from "./Home";

import {BrowserRouter, Routes , Route ,Link} from 'react-router-dom';

export default function Index (props){
    return(

        <div>
            <BrowserRouter>
                <Header/>
                <Routes>
                    <Route path="/" element={<Home/>}/>
                </Routes>
            
                <Footer/>
            
            
            </BrowserRouter>


        </div>


    );


}