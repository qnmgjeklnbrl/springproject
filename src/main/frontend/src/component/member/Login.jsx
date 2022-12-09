import React from "react";

export default function Login(props){

    return(
        <div>
            <h3>로그인</h3>
            <form method="post" action="/member/getmember">
                이메일 : <input type="text" name="mid"/><br/>
                비밀번호 : <input type="password" name="mpassword"/><br/>
                <input type="submit" value="로그인"/>
               
            </form>
        </div>
    );


}