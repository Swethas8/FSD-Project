import React,{useState} from "react";
import { Link,useNavigate } from "react-router-dom";
import { Footer, Navbar } from "../components";

import axios from 'axios';
function Login() {
    const[email,setEmail]=useState();
    const[password,setPassword]=useState();
    const navigate=useNavigate();
    const handleSubmit=()=>{
                axios.post("http://localhost:8181/api/v1/auth/authenticate",{
                    "email":email,
                "password":password
            })
            .then(res=>{
                console.log(res.data);
                localStorage.setItem("token",res.data.token);
                navigate("/Home");
                
            })
            .catch(err => {
                console.log(err);
            })
    }
  return (
    <>
      <Navbar />
      <div className="container my-3 py-3">
        <h1 className="text-center">Login</h1>
        <hr />
        <div class="row my-4 h-100">
          <div className="col-md-4 col-lg-4 col-sm-8 mx-auto">
            <form>
              <div class="my-3">
                <label for="display-4">Email address</label>
                <input
                  type="email"
                  class="form-control"
                  id="floatingInput"
                  value={email}
                  placeholder="name@example.com"
                  onChange={(event=>{setEmail(event.target.value)})}
                />
              </div>
              <div class="my-3">
                <label for="floatingPassword display-4">Password</label>
                <input
                  type="password"
                  class="form-control"
                  id="floatingPassword"
                  placeholder="Password"
                  value={password}
                  onChange={(event=>{setPassword(event.target.value)})}

                />
              </div>
              <div className="my-3">
                <p>New Here? <Link to="/Register" className="text-decoration-underline text-info">Register</Link> </p>
              </div>
              <div className="text-center">
                <Link to="/Home">
                <button class="my-2 mx-auto btn btn-dark" type="submit" onClick={()=>{handleSubmit()}}>
                  Login
                </button>
                </Link>
              </div>
            </form>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default Login;
