import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { Link, useParams } from "react-router-dom";
import DashMenu from "../layout/DashMenu";

export default function Dashboard() {

    const [users, setUsers] = useState([]);

    const {id} = useParams();
    useEffect(()=>{
        loadUsers();
    }, []);

    const loadUsers = async () => {
        const result = await axios.get("http://localhost:8080/users");
        setUsers(result.data);
    };

    const deleteUser = async (id) => {
        await axios.delete(`http://localhost:8080/user/${id}`);
        loadUsers();
    }

    return(
        <div className='contaner'>
            <div className="row">
                <DashMenu/>
                <div className="py-4">
                    <div className="card">
                        <div className="card-header">
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>FirstName</b>
                                    
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}