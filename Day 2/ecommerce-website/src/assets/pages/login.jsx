import React, { useState } from 'react';
import './login.css';
import { Link } from 'react-router-dom';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [showPassword, setShowPassword]=useState('');
  const [error, setError] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Perform validation and handle login logic here
    if (password !== 'password123') {
      setError('Incorrect password. Please try again.');
    } else {
      setError('');
      // Handle successful login
    }
  };

  const handleForgotPassword = () => {
    // Handle forgot password logic here
  };

  return (
    <div className="login-container">
      <div className="login-form">
        <h2 className="login-header">Sign In</h2>
        {error && <p className="error-message">{error}</p>}
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="email">Email:</label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="password">Password:</label>
            <input
              type={showPassword ? 'text' : 'password'}
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
            <button
              type="button"
              className="show-password-button"
              onClick={() => setShowPassword(!showPassword)}
            >
              {showPassword ? 'Hide' : 'Show'}
            </button>
          </div>
          <div className="form-group">
            <a href="#" onClick={handleForgotPassword} className="forgot-password-link">
              Forgot Password?
            </a>
          </div>
          <button type="submit" className="sign-in-button">
            Sign In
          </button>
        </form>
        <Link to='/register'>Register</Link>
      </div>
    </div>
  );
};

export default Login;