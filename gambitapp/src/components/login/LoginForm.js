import "../../css/style.css";
import { useState, Component } from "react";
import {Container, InputGroup, Form, Row, Col, Button} from 'react-bootstrap';

export class LoginForm extends Component {
    render() {
        return (

            <Container>
                <Row className="d-flex justify-content-center">
                    <Form className="form__login u-center-text">
                        <InputGroup className="form__login-input-group">
                            <InputGroup.Text id="email_field">E-Mail</InputGroup.Text>
                            <Form.Control placeholder="email" aria-label="email" aria-describedby="email"/>
                        </InputGroup>
                        <InputGroup className="form__login-input-group">
                            <InputGroup.Text id="password_field">Password</InputGroup.Text>
                            <Form.Control placeholder="password" aria-label="password" aria-describedby="password"/>
                        </InputGroup>
                        <Button variant="success">Login</Button>{' '}
                    </Form>
                </Row>
            </Container>
        
        );
    }
}

export default LoginForm;