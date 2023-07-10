import React from 'react';
import './App.css';
import {Route, Routes } from 'react-router-dom';
import Login from './assets/pages/login';
import Register from './assets/pages/register';


const App = () => {
  return (
    <>
        <Routes>
          <Route exact path="/" element={<Login />} />
          <Route exact path="/register" element={<Register />} />
        </Routes>
      </>
  );
};

export default App;