import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams  } from "react-router-dom";
import DashMenu from "../layout/DashMenu";

export default function UploadImageUser() {

    let navigate = useNavigate();

    const { id } = useParams();

    const [photo, setPhoto] = useState(null);
      
    function handleFileSelect(ev) {
        console.log('yo', ev.target.name, ev.target.value);
        const elem = document.getElementById('file');
        const profile_img = document.getElementById('profile_img');

        if (elem.files && elem.files[0]) {
            var reader = new FileReader();
            setPhoto(elem.files[0]);
            reader.onload = function (e) {
                profile_img.src = reader.result;
            }
    
            reader.readAsDataURL(elem.files[0]);
        }
    }


    

    const onSubmit = async (e) => {
        e.preventDefault();
        let data = new FormData();
        console.log("Photo: ", photo);
        data.append("file", photo);
        await axios.post(`http://localhost:8080/upload/${id}`, data, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        })
        .then(res => {
            console.log(res.data + 'uploaded successfully!');
         })
         .catch(err => console.error(err));
        //navigate("/dashboard/" + id);
    };

    return <div className="container">
        <div className="row">
            <DashMenu/>
            <div className="col-md-8 center-block offset-md-2 border rounded p-3 mt-2 shadow">
                <h2 className="text-center m-4">Upload Profile Image</h2>
                <img src="./../assets/blank_profile_pic.png" alt="Avatar" id="profile_img" className="w-50 border border-primary rounded-circle"/>

                <form method="post" action="#" encType="multipart/form-data" onSubmit={(e) => onSubmit(e)}>
                    <div className="mb-3">
                        <label htmlFor="Password" className="form-label">
                            Image
                        </label>
                        <input 
                        id="file" 
                        className="form-control"
                        type="file" 
                        name="file" 
                        accept="image/**"
                        onChange={(e) => handleFileSelect(e)}
                         />

                    </div>
                    <button type="submit" className="btn btn-outline-primary">Upload</button>
                    <Link className="btn btn-outline-danger mx-2" to={'/edituser/' + id}>Cancel</Link>
                </form>
            </div>
        </div>
    </div>;
}