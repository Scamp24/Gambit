import "../../css/style.css";
import {useState, setState, setMessage, Component } from "react";
import {Container, InputGroup, Form, Row, Col, Button, useAccordionButton} from 'react-bootstrap';


export class DashboardForm extends Component {

    render() {
        return (
            <Container>
            <Row>
                <h1>Sign Up</h1>
            </Row>
            <Row className="d-flex justify-content-center">
                <Form className="form__login u-center-text" action="@{/login}" method="post">

                    <Button variant="dislike">Dislike</Button>{' '}
                    <Button variant="like">Like</Button>{' '}
                </Form>
            </Row>
        </Container>
        
        );
    }
}

export default DashboardForm;