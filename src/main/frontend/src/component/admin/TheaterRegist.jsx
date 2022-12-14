import React from "react";
import axios from "axios";
import { useState } from "react";



export default function TheaterRegist(props){
    
    let theater= "";
    //const[theater,setTheater] =  useState("");
      //영화관 등록 함수
       const setTname = () => {
            if(theater==""){alert("영화관 이름을 입력후 등록해주세요");return;}
            axios
                .post( "/admin/settname", {tname:theater})
                .then(res=>{
                    if(res.data==true){alert("영화관 등록 성공") ;document.querySelector(".tnamebox").value=""}
                    else{alert("영화관 등록 실패")}

            
                })
                .catch(err=>{console.log(err)})


        }


    return(
        <div>
            <h3>극장등록</h3>
            극장이름: <input   className="tnamebox" type="text"  onChange={ (e) => (theater = e.target.value) }/>
            <button onClick={setTname}> 등록 </button>


        </div>



    );

}

