import React from 'react';
import ReactDOM from 'react-dom/client';
import '../node_modules/font-awesome/css/font-awesome.min.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Provider } from 'react-redux';
import store from './redux/store';

import { Home, Product, Products, AboutPage, ContactPage, Cart, Register, Checkout, PageNotFound, Login } from "./pages"
import Mains from './pages/Who';
import FeedForm from './pages/Feedback';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <Provider store={store}>
      <Routes>
        <Route path="/" element={<Mains />} />
        <Route path="/Home" element={<Home />} />
        <Route path="/product" element={<Products />} />
        <Route path="/product/:id" element={<Product />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/cart" element={<Cart />} />
        <Route path="/Login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/Feedback" element={<FeedForm/>}/>
        <Route path="/checkout" element={<Checkout />} />
        <Route path="*" element={<PageNotFound />} />
        <Route path="/product/*" element={<PageNotFound />} />
      </Routes>
    </Provider>
  </BrowserRouter>
);