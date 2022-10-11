import React, {useEffect, useState} from "react";
import "./loginform.css"

const LoginForm = () => {

    const [popupStyle, showPopup] = useState("hide")

    const login = () => {
        var username = document.getElementById('login_field').value;
        var password = document.getElementById('password_field').value;

        
    }

    const popup = () => {
        showPopup("login-popup")
        setTimeout(() => showPopup("hide"), 3000)
    }

    const onSuccess = e => {
        //alert("User signed in")
        console.log(e)
    }

    const onFailure = e => {
        alert("User sign in Failed")
        console.log(e)
    }


    return (
        <div className="cover">
            <h1>Login</h1>
            <input id="login_field" type="text" placeholder="username" />
            <input id="password_field" type="password" placeholder="password" />

            <div className="login-btn" onClick={login}>Login</div>


            <div className={popupStyle}>
                <h3>Login Failed</h3>
                <p>Username or password incorrect</p>
            </div>
            
        </div>
    )
}

export default LoginForm