import "../../css/style.css";
import {useState, setState, setMessage, Component } from "react";
import {Container, InputGroup, Form, Row, Col, Button, useAccordionButton} from 'react-bootstrap';


export class LoginForm extends Component {

    constructor(props) {
        super(props)
        this.state ={
            email: "",
            password: "",
            //errorMessage: ""
        };
        this.updateEmailValue = this.updateEmailValue.bind(this);
        this.updatePasswordValue = this.updatePasswordValue.bind(this);
        //this.errorMessage = this.setErrorMessage.bind(this);
        this.sendLogin = this.sendLogin.bind(this);
    }

    updateEmailValue(e){
        this.state.email = e.target.value;
        //console.log('email ', this.state);
    }

    updatePasswordValue(e){
        this.state.password = e.target.value;
        //console.log('password ', this.state);
    }

   // setErrorMessage(e){
        //this.state.errorMessage = e.target.value;
        //console.log('password ', this.state);
   // }


    sendLogin() {
        console.log("Sending login data...");

        var email = this.state.email;
        var password = this.state.password;
        //var errorMessage = this.state.errorMessage;
        /*fetch('http://localhost:8080/login', {
            method: 'POST',
            data: { email: this.state.email, password: this.state.password}
        });*/
        fetch('http://localhost:8080/login', {  
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'charset': 'utf-8',
        },
        body: JSON.stringify({
            email: this.state.email,
            password: this.state.password,
            errorMessage: this.state.errorMessage,
        })}).then((response) => response.json())
        .then((responseData) => {
            console.log(responseData);
        }).catch((error) => {
            console.log("Error");
        });
        
        console.log({credentails: email, password, errorMessage});
    }

    render() {
        return (

            <Container>
                <Row className="d-flex justify-content-center">
                    <Form className="form__login u-center-text" action="login">
                        <InputGroup className="form__login-input-group">
                            <InputGroup.Text id="email_field" >E-Mail</InputGroup.Text>
                            <Form.Control placeholder="email" aria-label="email" aria-describedby="email" name="email" type="text" 
                             onChange={e => this.updateEmailValue(e)}/>
                        </InputGroup>
                        <InputGroup className="form__login-input-group">
                            <InputGroup.Text id="password_field" >Password</InputGroup.Text>
                            <Form.Control placeholder="password" aria-label="password" aria-describedby="password" name="password" type="password" onChange={e => this.updatePasswordValue(e)}/>
                        </InputGroup>
                        <Button variant="success" onClick={this.sendLogin}>Login</Button>{' '}
                    </Form>
                </Row>
            </Container>
        
        );
    }
}

export default LoginForm;