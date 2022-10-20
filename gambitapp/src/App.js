import React from 'react';
import './App.css';
import {useState, useEffect} from 'react';
import LoginForm from './components/login/LoginForm';

const App = () => {

  /*useEffect(() => {
    fetch('http://localhost:8080/messages')
    .then(response => response.json())
    .then(
      (result) => {
        console.log('called get items')
        console.log(result)
        setItems(result);
      },
      //Note: it's important to handle errors here
      // instead of a catch() block so that we don't swallow
      //exceptions from actual bugs in components
      (error) => {
        setError(error);
      }
    )
  }, [])*/
  return (
    <div className="App">
      <LoginForm />
    </div>
    /*<div className="App">
      <h1>Here's Your messages</h1>
       <ul>
        {items && items.map(item => (
          <div key={item.name}>
           <h3>Hi {item.name},  {item.content}</h3>  
       
          </div>
        ))}
      </ul>
    </div>*/
  )
}

export default App;