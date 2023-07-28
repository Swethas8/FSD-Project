import React, { useState } from 'react'
import { Footer, Navbar } from "../components";
import { Link } from 'react-router-dom';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
function Register() {
const[username,setUsername]=useState();
const[email,setEmail]=useState();
const[password,setPassword]=useState();
const[confirmPassword,setConfirmPassword]=useState();
const navigate=useNavigate();
const handleSubmit=()=>{
try{

axios.post("http://localhost:8181/api/v1/auth/register",{
"name":username,
"email":email,
"password":password
})
.then(res=>{
console.log(res.data);
navigate("/Login");

})
.catch(function (error) {
console.log(error.response.status);
})
}
catch(error){
console.log("Error"+error.response.status);
}
}
    return (
        <>
            <Navbar />
            <div className="container my-3 py-3">
                <h1 className="text-center">Register</h1>
                <hr />
                <div class="row my-4 h-100">
                    <div className="col-md-4 col-lg-4 col-sm-8 mx-auto">
                        <form>
                            <div class="form my-3">
                                <label for="Name">UserName</label>
                                <input
                                    type="email"
                                    class="form-control"
                                    id="Name"
                                    placeholder="Enter Your Name"
                                    onChange={(event)=>{setUsername(event.target.value)}}
                                />
                            </div>
                            <div class="form my-3">
                                <label for="Email">Email address</label>
                                <input
                                    type="email"
                                    class="form-control"
                                    id="Email"
                                    placeholder="name@example.com"
                                    onChange={(event)=>{setEmail(event.target.value)}}
                                />
                            </div>
                            <div class="form  my-3">
                                <label for="Password">Password</label>
                                <input
                                    type="password"
                                    class="form-control"
                                    id="Password"
                                    placeholder="Password"
                                    onChange={(event)=>{setPassword(event.target.value)}}
                                />
                            </div>
                            <div class="form  my-3">
                                <label for="Password">Confirm Password</label>
                                <input
                                    type="password"
                                    class="form-control"
                                    id="Password"
                                    placeholder="Confirm Password"
                                    onChange={(event)=>{setConfirmPassword(event.target.value)}}
                                />
                            </div>
                            <div className="my-3">
                                <p>Already has an account? <Link to="/login" className="text-decoration-underline text-info">Login</Link> </p>
                            </div>
                            <div className="text-center">
                                <button class="my-2 mx-auto btn btn-dark" type="submit" onClick={handleSubmit}>
                                    Register
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    )
}

export default Register