import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { Link, useParams } from "react-router-dom";

export default function Login() {

    const [user, setUser]=useState({
        email:"",
        firstName:"",
        lastName:"",
        username:"",
        password:"",

    })

    const{email, password}=user;

    const onInputChange= (e) => {
        setUser({...user,[e.target.name]:e.target.value})
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.get("http://localhost:8080/user", user);
        //navigate("/login");
    };

    return(
        <div className="container">
            <div className="row">
                <form onSubmit={(e) => onSubmit(e)}>
                <div className="mb-3 my-2">
                        <label htmlFor="Email" className="form-label">
                            E-mail
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="E-mail"
                            name="email"
                            value={email}
                            onChange={(e) => onInputChange(e)}/>
                    </div>
                </form>
            </div>
        </div>
    )
}