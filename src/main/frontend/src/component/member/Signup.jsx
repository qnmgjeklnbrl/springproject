import React from 'react';

import axios from 'axios'; //   npm install axios 설치 했을경우만 가능

function Signup( props ){ // * 회원가입 컴포넌트 *
    // 1. setmember 이벤트 함수 정의 [ 화살표함수 정의 ]
    const setmember = () => {
        let info = {    // 2. 입력받은 값 가져오기
            mid : document.querySelector('.mid').value ,
            mpassword : document.querySelector('.mpassword').value ,
            manme: document.querySelector(".mname").value,
            mphone : document.querySelector('.mphone').value,
            memail: document.querySelector(".memail").value
        }

        axios           // 3. axios 비동기통신 이용한 서버[spring] 통신
            .post( "http://localhost:8085/member/setmember" ,  info )   // 요청메소드 ( rul , data )
            .then( res => { // 응답
                let result = res.data ;
                if( result != 0 ){ // 회원가입 성공
                    alert('회원가입 성공')
                }else{ // 회원가입 실패
                    alert('회원가입 실패')
                }
             } )
            .catch( err => { console.log( err ) } )                             // 예외처리

    }
   
    return(
            <div>
                <h3> 회원가입 </h3>
            
                아이디 : <input type="text" className="mid" /><br/>
                비밀번호 : <input type="text" className="mpassword" /><br/>
                이름: <input type="text" className="mname" /><br/>
                핸드폰 : <input type="text" className="mphone" /><br/>
                이메일:<input type="text" className="memail" /><br/>
               
                <button type="button" onClick={ setmember } > 가입하기 </button>
            </div>
    );
}
export default Signup;
