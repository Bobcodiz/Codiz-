import React from "react";
import {Navbar, NavItem} from "react-bootstrap";
import {NavLink} from "react-router-dom";

export default function TopNavBar(){
    return(
        <>
            <div>
                <Navbar>
                    <NavItem>
                        <NavLink to={'/'}>Home</NavLink>
                        <NavLink to={'/contact'}>Contact-us</NavLink>
                    </NavItem>
                </Navbar>
            </div>
        </>
    )
}
