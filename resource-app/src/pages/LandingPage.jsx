import React from "react";
import {Container} from "react-bootstrap";
import "../styles/LandingPageStyles.css"
import TopNavBar from "../components/TopNavBar";


export default function LandingPage(){
    return(
        <>
            <Container className={'landing'}>

                <div>
                    <TopNavBar/>
                </div>

            </Container>
        </>
    )
}
