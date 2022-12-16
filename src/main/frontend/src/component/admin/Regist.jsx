import React from "react";
import { useState } from "react";
import {BrowserRouter, Routes , Route ,Link, Router} from 'react-router-dom';
import TheaterRegist from "./TheaterRegist";
import Sidemenu from "./Sidemenu";


export default function Regist(props){
    return(
        <div>
        <Sidemenu/>

        <Routes>
            <Route path="/tregist" element={<TheaterRegist/>}  />
        </Routes>
           




        
    </div>



    );

   
   
     
           
              


          
         
           
       
    


    




}

