import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { json, Link, useParams } from "react-router-dom";
import DashMenu from "../layout/DashMenu";

export default function Dashboard() {

    var index = 0;
    const [user, setUser]=useState([]);
    const{email, firstName, lastName, username, password, photo} = user;
    const {id} = useParams();

    useEffect(()=>{
        loadData();
    }, []);

    const loadData = async () => {
        const result = await axios.get("http://localhost:8080/candidates/" + id);
        //setUser({user, [1]:result.data})
        //setUser(result.data);
        user.push(result.data);
        //user.map(u => console.log("user: --", u[0]));
        console.log("data:", result.data);
    };



    return(
        <div className='contaner'>
            <div className="row">
                <DashMenu/>
                <div className="py-4">
                <div className="card">
                        <div className="card-header" >
                            Details of user id: {user.map((i, candidate) => {
                               
                                    return <p key={i}>{candidate.email}</p>;
                            
                            })}
                            <ul className="list-group list-group-flush">

                                <li className="list-group-item">
                                    <b>First Name:</b>
                                </li>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}