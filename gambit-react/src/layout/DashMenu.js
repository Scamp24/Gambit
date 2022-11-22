import React from 'react';
import { Link } from "react-router-dom";

export default function DashMenu() {
    return(
        <div>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <a className="link-unstyled" href="#"><i className="fa-regular fa-user fa-2x m-3 shadow-none"></i></a>
            <a className="link-unstyled" href="#"><i className="fa-solid fa-dice fa-2x"></i></a>
            <a className="link-unstyled" href="#"><i className="fa-regular fa-envelope fa-2x m-3"></i></a>


            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="mr-auto">
                <li >
                    <a  href="#">Home <span className="sr-only">(current)</span></a>
                </li>

                </ul>
            </div>
            </nav>
        </div>
    )
}