import React from "react";
import { Footer, Navbar } from "../components";
const ContactPage = () => {
  return (
    <>
      <Navbar />
      <div className="container my-3 py-3">
        <h1 className="text-center">Hello there.</h1>
        <h1 className="text-center">How Can We Help?</h1>
        <hr />
        <div class="row my-4 h-100">
        
      <br></br>
      <br></br>
      <p style={{textAlign:"center"}}>For any queries,send us a message to swetha@gmail.com</p>
      <p style={{textAlign:"center"}}>Contact us at any time to +910987654321.
      </p>
              
          </div>
        </div>
      <Footer />
    </>
  );
};

export default ContactPage;
